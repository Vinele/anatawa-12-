package com.vinelles.testmod.init;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class KeybindsRegister {
    private static final String CATEGORY = "TEST MOD";
    public static final KeyBinding KEY_MOUNT = new KeyBinding("key.mount", Keyboard.KEY_K, CATEGORY);
    public static final KeyBinding KEY_GUI = new KeyBinding("key.open_gui", Keyboard.KEY_NUMPAD5, CATEGORY);
    public static final KeyBinding KEY_CLOSE_GUI = new KeyBinding("key.close_gui", Keyboard.KEY_NUMPAD6, CATEGORY);


    public static void register() {
        setRegister(KEY_MOUNT);
        setRegister(KEY_GUI);
        setRegister(KEY_CLOSE_GUI);
    }

    private static void setRegister(KeyBinding binding) {
        ClientRegistry.registerKeyBinding(binding);
    }
}