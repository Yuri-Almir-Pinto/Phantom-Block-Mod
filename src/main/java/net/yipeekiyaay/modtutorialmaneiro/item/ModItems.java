package net.yipeekiyaay.modtutorialmaneiro.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.yipeekiyaay.modtutorialmaneiro.ModTutorialManeiro;



public class ModItems {
    // Montagem do item.
    public static final Item PHANTOM_BLOCK = registerItem("phantom_block",
            new Item(new FabricItemSettings()));
    private static void addItemsToBuildingBlocksGroup(FabricItemGroupEntries entries) {
        entries.add(PHANTOM_BLOCK);
    }

    private static Item registerItem(String name, Item item) {
        // Registra um item como um item, com o identificador do mod, e passa o item em si.
        return Registry.register(Registries.ITEM, new Identifier(ModTutorialManeiro.MOD_ID, name), item);
    }
    public static void registerModItems() {
        // Mostra no log o que está fazendo
        ModTutorialManeiro.LOGGER.info("Registering items from the mod!");

        // Adiciona o item que estamos criando para a tab de "Blocos de construção" do criativo.
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModItems::addItemsToBuildingBlocksGroup);
    }
}
