package com.vinelles.testmod.item.block;

import com.vinelles.testmod.TestMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class BlockBestStone extends Block {
    public BlockBestStone(String name) {
        super(Material.GROUND);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(TestMod.CTAB);
    }

    //isOpaqueCube: Используется для блоков, которые не должны пропускать свет, например, для стен, земли, камня и т.д. Если ваш блок должен пропускать свет (например, стекло), этот метод должен возвращать false.
    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    //isFullCube: Используется для блоков, которые должны занимать весь объем куба, например, для стандартных блоков, таких как камень или земля. Если ваш блок имеет сложную форму или не занимает весь объем (например, ступеньки или заборы), этот метод должен возвращать false.
    @Override
    public boolean isFullCube(IBlockState state) {
        return true;
    }
}
