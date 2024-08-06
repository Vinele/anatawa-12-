package com.vinelles.testmod.item.block;

import com.vinelles.testmod.TestMod;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class OrangeOre extends Block {
    public OrangeOre(String name, Material material, float hardness, float resistanse, SoundType soundType) {
        super(material);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setHardness(hardness);
        this.setResistance(resistanse);
        this.setSoundType(soundType);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }


    @Override
    public boolean isFullCube(IBlockState state) {
        return true;
    }
}
