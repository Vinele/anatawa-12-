package com.vinelles.testmod.item.block;

import com.vinelles.testmod.item.block.tileentity.BlockTileEntity;
import com.vinelles.testmod.tiles.TileEntityCounter;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;


public class BlockCounter extends BlockTileEntity<TileEntityCounter> {

    public BlockCounter(String name, Material material, float hardness, float resistanse, SoundType soundType) {

        super(name, material, hardness, resistanse, soundType);

        this.setHarvestLevel("pickaxe", 3);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos position, IBlockState blockState, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {

        if (!world.isRemote) {

            TileEntityCounter tileEntity = getTileEntity(world, position);

            if (side == EnumFacing.DOWN) {

                tileEntity.decrementCount();

            }

            else if (side == EnumFacing.UP) {

                tileEntity.incrementCount();
            }

            String dead = "";
            if(player.isDead == false)
                dead = "Not dead";
            player.sendMessage(new TextComponentString("Count: " + tileEntity.getCount() +" "+ dead +" "+ player.getName()));
        }

        return true;
    }

    @Override
    public Class<TileEntityCounter> getTileEntityClass() {

        return TileEntityCounter.class;
    }

    @Override
    public TileEntityCounter createTileEntity(World world, IBlockState blockState) {

        return new TileEntityCounter();
    }
}