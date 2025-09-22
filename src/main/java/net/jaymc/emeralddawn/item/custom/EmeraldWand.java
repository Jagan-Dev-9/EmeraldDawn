package net.jaymc.emeralddawn.item.custom;

import net.jaymc.emeralddawn.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.Map;

public class EmeraldWand extends Item {
    private static final Map<Block, Block> WAND_MAP =
            Map.of(
                    Blocks.EMERALD_BLOCK, ModBlocks.ETHERNAL_EMERALD_BLOCK
            );

    public EmeraldWand(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(WAND_MAP.containsKey(clickedBlock)) {
            if(!world.isClient()){
                world.setBlockState(context.getBlockPos(),WAND_MAP.get(clickedBlock).getDefaultState());

                context.getStack().damage(1,((ServerWorld) world),((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null,context.getBlockPos(), SoundEvents.BLOCK_AMETHYST_BLOCK_RESONATE, SoundCategory.BLOCKS);
            }
        }

        return ActionResult.SUCCESS;
    }
}
