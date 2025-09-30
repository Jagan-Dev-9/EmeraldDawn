package net.jaymc.emeralddawn.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AllayEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.*;

public class EmeraldAllayEntity extends AllayEntity {
    private static final int SEARCH_RADIUS = 32;
    private static final int MAX_TRACKED_ORES = 10;
    private final Set<Item> trackedOres = new HashSet<>();
    private final Map<Item, Integer> oreCount = new HashMap<>();
    private BlockPos targetOrePos;
    private int searchCooldown = 0;
    private boolean isTrackingMode = false;

    public EmeraldAllayEntity(EntityType<? extends AllayEntity> entityType, World world) {
        super(entityType, world);
        initializeDefaultTrackedOres();
    }

    private void initializeDefaultTrackedOres() {
        trackedOres.add(Items.COAL);
        trackedOres.add(Items.COPPER_INGOT);
        trackedOres.add(Items.IRON_INGOT);
        trackedOres.add(Items.GOLD_INGOT);
        trackedOres.add(Items.REDSTONE);
        trackedOres.add(Items.LAPIS_LAZULI);
        trackedOres.add(Items.DIAMOND);
        trackedOres.add(Items.EMERALD);
        trackedOres.add(Items.NETHERITE_INGOT);
        trackedOres.add(Items.QUARTZ);
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(1, new EmeraldAllayEntity.OreTrackingGoal());
        this.goalSelector.add(2, new EmeraldAllayEntity.OreCollectionGoal());
        this.goalSelector.add(3, new FollowPlayerGoal());
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);

        if (itemStack.isEmpty()) {
            toggleTrackingMode();
            return ActionResult.SUCCESS;
        }

        if (isOreItem(itemStack.getItem())) {
            addTrackedOre(itemStack.getItem());
            if (!player.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }
            return ActionResult.SUCCESS;
        }

        return super.interactMob(player, hand);
    }

    public void toggleTrackingMode() {
        isTrackingMode = !isTrackingMode;
        if (isTrackingMode) {
            this.getWorld().addParticle(ParticleTypes.HAPPY_VILLAGER, this.getX(), this.getY() + 1, this.getZ(), 0, 0, 0);
            this.playSound(SoundEvents.ENTITY_ALLAY_AMBIENT_WITH_ITEM, 1.0F, 1.2F);
        } else {
            this.getWorld().addParticle(ParticleTypes.SMOKE, this.getX(), this.getY() + 1, this.getZ(), 0, 0, 0);
            this.playSound(SoundEvents.ENTITY_ALLAY_AMBIENT_WITHOUT_ITEM, 1.0F, 0.8F);
        }
    }

    public void addTrackedOre(Item ore) {
        if (trackedOres.size() < MAX_TRACKED_ORES) {
            trackedOres.add(ore);
            oreCount.put(ore, oreCount.getOrDefault(ore, 0) + 1);
            this.playSound(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, 0.5F, 1.5F);
        }
    }

    public void removeTrackedOre(Item ore) {
        trackedOres.remove(ore);
        oreCount.remove(ore);
    }

    private boolean isOreItem(Item item) {
        return item == Items.COAL || item == Items.COPPER_INGOT || item == Items.IRON_INGOT ||
                item == Items.GOLD_INGOT || item == Items.REDSTONE || item == Items.LAPIS_LAZULI ||
                item == Items.DIAMOND || item == Items.EMERALD || item == Items.NETHERITE_INGOT ||
                item == Items.QUARTZ;
    }

    @Override
    public void tick() {
        super.tick();

        if (this.getWorld().isClient) {
            if (isTrackingMode && this.age % 20 == 0) {
                spawnTrackingParticles();
            }
            return;
        }

        if (searchCooldown > 0) {
            searchCooldown--;
        }

        if (isTrackingMode && searchCooldown <= 0) {
            searchForOres();
            searchCooldown = 60;
        }
    }

    private void spawnTrackingParticles() {
        for (int i = 0; i < 3; i++) {
            double x = this.getX() + (this.random.nextGaussian() * 0.5);
            double y = this.getY() + 0.5 + (this.random.nextGaussian() * 0.3);
            double z = this.getZ() + (this.random.nextGaussian() * 0.5);
            this.getWorld().addParticle(ParticleTypes.END_ROD, x, y, z, 0, 0.02, 0);
        }
    }

    private void searchForOres() {
        BlockPos currentPos = this.getBlockPos();
        List<BlockPos> nearbyOres = new ArrayList<>();

        for (int x = -SEARCH_RADIUS; x <= SEARCH_RADIUS; x++) {
            for (int y = -SEARCH_RADIUS; y <= SEARCH_RADIUS; y++) {
                for (int z = -SEARCH_RADIUS; z <= SEARCH_RADIUS; z++) {
                    BlockPos checkPos = currentPos.add(x, y, z);
                    BlockState state = this.getWorld().getBlockState(checkPos);

                    if (isTargetOreBlock(state)) {
                        nearbyOres.add(checkPos);
                    }
                }
            }
        }

        if (!nearbyOres.isEmpty()) {
            nearbyOres.sort((pos1, pos2) -> {
                double dist1 = currentPos.getSquaredDistance(pos1);
                double dist2 = currentPos.getSquaredDistance(pos2);
                return Double.compare(dist1, dist2);
            });

            targetOrePos = nearbyOres.get(0);
            this.playSound(SoundEvents.ENTITY_ALLAY_ITEM_GIVEN, 0.7F, 1.3F);
        }
    }

    private boolean isTargetOreBlock(BlockState state) {
        return state.isOf(net.minecraft.block.Blocks.COAL_ORE) ||
                state.isOf(net.minecraft.block.Blocks.DEEPSLATE_COAL_ORE) ||
                state.isOf(net.minecraft.block.Blocks.COPPER_ORE) ||
                state.isOf(net.minecraft.block.Blocks.DEEPSLATE_COPPER_ORE) ||
                state.isOf(net.minecraft.block.Blocks.IRON_ORE) ||
                state.isOf(net.minecraft.block.Blocks.DEEPSLATE_IRON_ORE) ||
                state.isOf(net.minecraft.block.Blocks.GOLD_ORE) ||
                state.isOf(net.minecraft.block.Blocks.DEEPSLATE_GOLD_ORE) ||
                state.isOf(net.minecraft.block.Blocks.REDSTONE_ORE) ||
                state.isOf(net.minecraft.block.Blocks.DEEPSLATE_REDSTONE_ORE) ||
                state.isOf(net.minecraft.block.Blocks.LAPIS_ORE) ||
                state.isOf(net.minecraft.block.Blocks.DEEPSLATE_LAPIS_ORE) ||
                state.isOf(net.minecraft.block.Blocks.DIAMOND_ORE) ||
                state.isOf(net.minecraft.block.Blocks.DEEPSLATE_DIAMOND_ORE) ||
                state.isOf(net.minecraft.block.Blocks.EMERALD_ORE) ||
                state.isOf(net.minecraft.block.Blocks.DEEPSLATE_EMERALD_ORE) ||
                state.isOf(net.minecraft.block.Blocks.NETHER_QUARTZ_ORE) ||
                state.isOf(net.minecraft.block.Blocks.ANCIENT_DEBRIS);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putBoolean("IsTrackingMode", isTrackingMode);

        NbtCompound oreData = new NbtCompound();
        for (Map.Entry<Item, Integer> entry : oreCount.entrySet()) {
            oreData.putInt(entry.getKey().toString(), entry.getValue());
        }
        nbt.put("OreCount", oreData);

        if (targetOrePos != null) {
            nbt.putLong("TargetOrePos", targetOrePos.asLong());
        }
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        isTrackingMode = nbt.getBoolean("IsTrackingMode");

        if (nbt.contains("OreCount")) {
            NbtCompound oreData = nbt.getCompound("OreCount");
            oreCount.clear();
            for (String key : oreData.getKeys()) {
                Item item = Items.COAL;
                oreCount.put(item, oreData.getInt(key));
            }
        }

        if (nbt.contains("TargetOrePos")) {
            targetOrePos = BlockPos.fromLong(nbt.getLong("TargetOrePos"));
        }
    }

    public Set<Item> getTrackedOres() {
        return new HashSet<>(trackedOres);
    }

    public Map<Item, Integer> getOreCount() {
        return new HashMap<>(oreCount);
    }

    public boolean isTrackingMode() {
        return isTrackingMode;
    }

    public BlockPos getTargetOrePos() {
        return targetOrePos;
    }

    class OreTrackingGoal extends Goal {
        public OreTrackingGoal() {
            this.setControls(EnumSet.of(Goal.Control.MOVE, Goal.Control.LOOK));
        }

        @Override
        public boolean canStart() {
            return isTrackingMode && targetOrePos != null &&
                    EmeraldAllayEntity.this.squaredDistanceTo(Vec3d.ofCenter(targetOrePos)) > 4.0;
        }

        @Override
        public void start() {
            EmeraldAllayEntity.this.getNavigation().startMovingTo(
                    targetOrePos.getX(), targetOrePos.getY(), targetOrePos.getZ(), 1.0
            );
        }

        @Override
        public void stop() {
            EmeraldAllayEntity.this.getNavigation().stop();
        }

        @Override
        public void tick() {
            if (targetOrePos != null) {
                EmeraldAllayEntity.this.getLookControl().lookAt(
                        targetOrePos.getX(), targetOrePos.getY(), targetOrePos.getZ()
                );

                if (EmeraldAllayEntity.this.squaredDistanceTo(Vec3d.ofCenter(targetOrePos)) < 2.0) {
                    BlockState state = EmeraldAllayEntity.this.getWorld().getBlockState(targetOrePos);
                    if (isTargetOreBlock(state)) {
                        spawnIndicatorParticles();
                        EmeraldAllayEntity.this.playSound(SoundEvents.BLOCK_NOTE_BLOCK_CHIME.value(), 0.8F, 1.5F);
                    }
                    targetOrePos = null;
                }
            }
        }

        private void spawnIndicatorParticles() {
            if (targetOrePos != null) {
                for (int i = 0; i < 10; i++) {
                    double x = targetOrePos.getX() + 0.5 + (EmeraldAllayEntity.this.random.nextGaussian() * 0.3);
                    double y = targetOrePos.getY() + 1.0 + (EmeraldAllayEntity.this.random.nextGaussian() * 0.3);
                    double z = targetOrePos.getZ() + 0.5 + (EmeraldAllayEntity.this.random.nextGaussian() * 0.3);
                    EmeraldAllayEntity.this.getWorld().addParticle(ParticleTypes.GLOW_SQUID_INK, x, y, z, 0, 0.1, 0);
                }
            }
        }
    }

    class OreCollectionGoal extends Goal {
        private int collectionCooldown = 0;

        public OreCollectionGoal() {
            this.setControls(EnumSet.of(Goal.Control.MOVE));
        }

        @Override
        public boolean canStart() {
            return isTrackingMode && collectionCooldown <= 0 &&
                    EmeraldAllayEntity.this.getStackInHand(Hand.MAIN_HAND).isEmpty();
        }

        @Override
        public void tick() {
            if (collectionCooldown > 0) {
                collectionCooldown--;
                return;
            }

            BlockPos currentPos = EmeraldAllayEntity.this.getBlockPos();

            for (int radius = 1; radius <= 5; radius++) {
                for (int x = -radius; x <= radius; x++) {
                    for (int y = -2; y <= 2; y++) {
                        for (int z = -radius; z <= radius; z++) {
                            BlockPos checkPos = currentPos.add(x, y, z);
                            if (tryCollectOreItem(checkPos)) {
                                collectionCooldown = 100;
                                return;
                            }
                        }
                    }
                }
            }
        }

        private boolean tryCollectOreItem(BlockPos pos) {
            return EmeraldAllayEntity.this.getWorld().getEntitiesByClass(
                    net.minecraft.entity.ItemEntity.class,
                    new net.minecraft.util.math.Box(pos),
                    entity -> isOreItem(entity.getStack().getItem())
            ).stream().findFirst().map(itemEntity -> {
                ItemStack stack = itemEntity.getStack();
                if (trackedOres.contains(stack.getItem())) {
                    EmeraldAllayEntity.this.setStackInHand(Hand.MAIN_HAND, stack.copy());
                    oreCount.put(stack.getItem(), oreCount.getOrDefault(stack.getItem(), 0) + stack.getCount());
                    itemEntity.discard();
                    EmeraldAllayEntity.this.playSound(SoundEvents.ENTITY_ITEM_PICKUP, 0.8F, 1.2F);
                    return true;
                }
                return false;
            }).orElse(false);
        }
    }

    class FollowPlayerGoal extends Goal {
        private PlayerEntity targetPlayer;
        private int followCooldown = 0;

        public FollowPlayerGoal() {
            this.setControls(EnumSet.of(Goal.Control.MOVE, Goal.Control.LOOK));
        }

        @Override
        public boolean canStart() {
            if (followCooldown > 0) {
                followCooldown--;
                return false;
            }

            PlayerEntity nearestPlayer = EmeraldAllayEntity.this.getWorld().getClosestPlayer(
                    EmeraldAllayEntity.this, 16.0
            );

            if (nearestPlayer != null && !isTrackingMode) {
                targetPlayer = nearestPlayer;
                return EmeraldAllayEntity.this.squaredDistanceTo(nearestPlayer) > 36.0;
            }

            return false;
        }

        @Override
        public void start() {
            followCooldown = 60;
        }

        @Override
        public void stop() {
            targetPlayer = null;
        }

        @Override
        public void tick() {
            if (targetPlayer != null) {
                EmeraldAllayEntity.this.getLookControl().lookAt(targetPlayer, 10.0F, 10.0F);

                if (EmeraldAllayEntity.this.squaredDistanceTo(targetPlayer) > 144.0) {
                    EmeraldAllayEntity.this.getNavigation().startMovingTo(targetPlayer, 1.2);
                } else if (EmeraldAllayEntity.this.squaredDistanceTo(targetPlayer) < 9.0) {
                    EmeraldAllayEntity.this.getNavigation().stop();
                }
            }
        }
    }
}