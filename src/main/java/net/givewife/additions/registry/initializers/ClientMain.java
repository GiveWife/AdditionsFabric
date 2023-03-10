package net.givewife.additions.registry.initializers;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.givewife.additions.registry.registries.BlockRegistry;
import net.givewife.additions.registry.registries.KeybindRegistry;
import net.givewife.additions.registry.registries.MessageRegistry;
import net.givewife.additions.registry.registries.ParticleRegistry;
import net.minecraft.client.render.RenderLayer;

public class ClientMain implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        KeybindRegistry keybindRegistry = new KeybindRegistry();
        initializeMessages();
        initializeRenders();
        ParticleRegistry.registerClient();


    }

    private void initializeMessages() {
        System.out.println("[Client] Initializing messages");
        for(int i = 0; i < MessageRegistry.getMessages().length; i++) {
            MessageRegistry.getMessages()[i].registerClient();
        }
    }

    private void initializeRenders() {

        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.PROJECTOR_1, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.MOD_AIR, RenderLayer.getTranslucent());

    }

}
