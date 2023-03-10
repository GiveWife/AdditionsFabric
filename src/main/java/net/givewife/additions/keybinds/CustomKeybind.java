package net.givewife.additions.keybinds;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.givewife.additions.Main;
import net.givewife.additions.util.GeneralHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;

public abstract class CustomKeybind {

    private final KeyBinding keyBind;
    public GeneralHelper helper;
    private String name;

    public CustomKeybind(String name, String category, InputUtil.Type type, int key) {

        keyBind = KeyBindingHelper.registerKeyBinding(new KeyBinding(

                "key." + Main.MODID + "." + name,
                type,
                key,
                "category." + Main.MODID + "." + category


        ));

        this.name = name;
        this.helper = new GeneralHelper(name);

        register();

    }

    public abstract void run(MinecraftClient client);

    private void register() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (this.getKeybind().wasPressed()) {
                run(client);
            }
        });
    }

    /**
     * Returns the keybind that was initialized in the constructor
     */
    public KeyBinding getKeybind() {
        return keyBind;
    }

    /**
     * Returns the string of this keybind
     */
    public String getName() {
        return this.name;
    }

}
