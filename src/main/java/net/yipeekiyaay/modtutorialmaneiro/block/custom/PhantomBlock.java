package net.yipeekiyaay.modtutorialmaneiro.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.yipeekiyaay.modtutorialmaneiro.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

public class PhantomBlock extends Block {
    public PhantomBlock (Settings settings) {
        super(settings);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        world.scheduleBlockTick(pos, state.getBlock(), 300);
        PlayerEntity player = world.getPlayerByUuid(placer.getUuid());
        player.giveItemStack(ModBlocks.PHANTOM_BLOCK.asItem().getDefaultStack());
        super.onPlaced(world, pos, state, placer, itemStack);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        world.breakBlock(pos, false);
        super.scheduledTick(state, world, pos, random);
    }
}
