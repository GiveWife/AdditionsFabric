package net.givewife.additions.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.givewife.additions.Main;
import net.givewife.additions.objects.blocks.NetherReactorBlock;
import net.givewife.additions.objects.blocks.ProjectorBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BlockRegistry {

    public static final Block PROJECTOR_1 = new ProjectorBlock(AbstractBlock.Settings.copy(Blocks.GLASS).nonOpaque());
    public static final Block NETHER_REACTOR = new NetherReactorBlock(AbstractBlock.Settings.copy(Blocks.COBBLED_DEEPSLATE));

    public static void register() {

        Registry.register(Registries.BLOCK, new Identifier(Main.MODID, "ctrue_1"), PROJECTOR_1);
        Registry.register(Registries.ITEM, new Identifier(Main.MODID, "ctrue_1"), new BlockItem(PROJECTOR_1, new FabricItemSettings()));

        Registry.register(Registries.BLOCK, new Identifier(Main.MODID, "nether_reactor"), NETHER_REACTOR);
        Registry.register(Registries.ITEM, new Identifier(Main.MODID, "nether_reactor"), new BlockItem(NETHER_REACTOR, new FabricItemSettings()));

    }

}
