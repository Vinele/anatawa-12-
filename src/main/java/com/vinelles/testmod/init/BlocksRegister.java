package com.vinelles.testmod.init;

import com.vinelles.testmod.TestMod;
import com.vinelles.testmod.item.block.BlockBestStone;
import com.vinelles.testmod.item.block.BlockCounter;
import com.vinelles.testmod.item.block.OrangeOre;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlocksRegister {
    public static Block BEST_STONE = new BlockBestStone("best_stone");
    public static Block ORANGE_ORE = new OrangeOre("orange_ore", Material.ROCK, 1000.0f, 4000.0f, SoundType.STONE);

    public static final Block
            BLOCK_COUNTER = new BlockCounter("block_counter", Material.ROCK, 10.0F, 10.0F, SoundType.STONE).setCreativeTab(TestMod.CTAB);


    public static void register() {
        setRegister(BEST_STONE);
        setRegister(ORANGE_ORE);

        setRegister(BLOCK_COUNTER);
        GameRegistry.registerTileEntity(((BlockCounter) BLOCK_COUNTER).getTileEntityClass(), BLOCK_COUNTER.getRegistryName().toString());
    }

    @SideOnly(Side.CLIENT)
    public static void registerRender() {
        setRender(BEST_STONE);
        setRender(ORANGE_ORE);

        setRender(BLOCK_COUNTER);
        //registryModel(Item.getItemFromBlock(BEST_STONE));
    }

    private static void setRegister(Block block) {
        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }

    @SideOnly(Side.CLIENT)
    private static void setRender(Block block) {
        Minecraft.getMinecraft()
                .getRenderItem()
                .getItemModelMesher()
                .register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
    }


}