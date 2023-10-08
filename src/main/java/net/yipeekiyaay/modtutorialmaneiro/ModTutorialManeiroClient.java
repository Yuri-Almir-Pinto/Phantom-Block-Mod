package net.yipeekiyaay.modtutorialmaneiro;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.yipeekiyaay.modtutorialmaneiro.block.ModBlocks;

public class ModTutorialManeiroClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PHANTOM_BLOCK, RenderLayer.getTranslucent());
    }
}
