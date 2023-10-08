package net.yipeekiyaay.modtutorialmaneiro.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.yipeekiyaay.modtutorialmaneiro.ModTutorialManeiro;
import net.yipeekiyaay.modtutorialmaneiro.block.custom.PhantomBlock;

public class ModBlocks {
    public static final Block PHANTOM_BLOCK = registerBlock("phantom_block",
            new PhantomBlock(FabricBlockSettings.copyOf(Blocks.GLASS)
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .dropsNothing()
                    .nonOpaque()));
    // Caso queira criar um novo bloco completamente do zero, usar o .create(). ... E seguir.
    // Chamar métodos de atributos de bloco, como "sounds" e "dropsNothing" sobrescreve
    // propriedades passadas.

    private static void addBlocksToBuildingBlocksGroup(FabricItemGroupEntries entries) {
        entries.add(PHANTOM_BLOCK);
        // Adiciona para a aba de blocos de construção do criativo.
    }
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(ModTutorialManeiro.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(ModTutorialManeiro.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        ModTutorialManeiro.LOGGER.info("Registering Mod Blocks!");
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModBlocks::addBlocksToBuildingBlocksGroup);
    }
}
