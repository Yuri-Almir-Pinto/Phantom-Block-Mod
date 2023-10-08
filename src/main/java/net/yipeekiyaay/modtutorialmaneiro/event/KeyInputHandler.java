package net.yipeekiyaay.modtutorialmaneiro.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.yipeekiyaay.modtutorialmaneiro.ModTutorialManeiro;
import net.yipeekiyaay.modtutorialmaneiro.block.ModBlocks;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final String KEY_CATEGORY_MODTUTORIALMANEIRO = "category.modtutorialmaneiro.phantomblockmod";
    public static final String KEY_CHANGE_TO_PHANTOM_BLOCK = "key.modtutorialmaneiro.changetophantomblock";

    public static void registerKeyInputs() {
        KeyBinding keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_CHANGE_TO_PHANTOM_BLOCK, // The translation key of the keybinding's name
                InputUtil.Type.KEYSYM, // The type of the keybinding, KEYSYM for keyboard, MOUSE for mouse.
                GLFW.GLFW_KEY_R, // The keycode of the key
                KEY_CATEGORY_MODTUTORIALMANEIRO // The translation key of the keybinding's category.
        ));

        ServerTickEvents.END_WORLD_TICK.register(server -> {
                ClientTickEvents.END_CLIENT_TICK.register(client -> {
                    while (keyBinding.wasPressed()) {
                        if (client.player != null) {
                            PlayerEntity player = server.getPlayerByUuid(client.player.getUuid());
                            if (player != null) {
                                player.giveItemStack(ModBlocks.PHANTOM_BLOCK.asItem().getDefaultStack());
                            }
                            else {
                                ModTutorialManeiro.LOGGER.error("Error! For some reason 'player' is null! Can't give phantom blocks to something that doesn't exist!");
                            }
                        }
                        else {
                            ModTutorialManeiro.LOGGER.error("Error! For some reason 'client.player' is null! Can't give phantom blocks to something that doesn't exist!");
                        }
                    }
                });
        });
    }

}
