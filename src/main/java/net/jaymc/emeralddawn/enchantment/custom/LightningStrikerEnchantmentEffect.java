package net.jaymc.emeralddawn.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public record LightningStrikerEnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<LightningStrikerEnchantmentEffect> CODEC = MapCodec.unit(LightningStrikerEnchantmentEffect::new);

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos) {
        // Use the provided position (pos) which is already the correct target position
        BlockPos targetPos = BlockPos.ofFloored(pos);
        
        // Spawn lightning based on enchantment level
        for (int i = 0; i < level; i++) {
            LightningEntity lightning = EntityType.LIGHTNING_BOLT.create(world);
            if (lightning != null) {
                // For multiple strikes, add some randomness to position
                double offsetX = i > 0 ? (world.random.nextDouble() - 0.5) * 3 : 0;
                double offsetZ = i > 0 ? (world.random.nextDouble() - 0.5) * 3 : 0;
                
                lightning.refreshPositionAfterTeleport(
                    targetPos.getX() + offsetX, 
                    targetPos.getY(), 
                    targetPos.getZ() + offsetZ
                );
                world.spawnEntity(lightning);
            }
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}