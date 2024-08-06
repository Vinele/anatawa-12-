package com.vinelles.testmod.item.wings;

import com.vinelles.testmod.TestMod;
import net.minecraft.block.BlockDispenser;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemElytra;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.lang.reflect.Method;

//@Mod.EventBusSubscriber
//public class TestWings extends ItemElytra {
//    public TestWings() {
//        this.setRegistryName("test_wings");
//        this.setUnlocalizedName("test_wings");
//        this.setCreativeTab(TestMod.MODFOOD);
//        this.maxStackSize = 1;
//        this.setMaxDamage(432);
//        this.addPropertyOverride(new ResourceLocation("broken"), new IItemPropertyGetter() {
//            @SideOnly(Side.CLIENT)
//            public float apply(ItemStack stack, @Nullable World world, @Nullable EntityLivingBase entity) {
//                return ItemElytra.isUsable(stack) ? 0.0F : 1.0F;
//            }
//        });
//        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(this, ItemArmor.DISPENSER_BEHAVIOR);
//        MinecraftForge.EVENT_BUS.register(this);
//    }
//
//    @Override
//    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
//        return repair.getItem() == Items.LEATHER;
//    }
//
//    @Override
//    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
//        ItemStack itemstack = player.getHeldItem(hand);
//        EntityEquipmentSlot slot = EntityEquipmentSlot.CHEST;
//        ItemStack currentArmor = player.getItemStackFromSlot(slot);
//
//        if (currentArmor.isEmpty()) {
//            player.setItemStackToSlot(slot, itemstack.copy());
//            itemstack.setCount(0);
//            return new ActionResult<>(EnumActionResult.SUCCESS, itemstack);
//        } else {
//            return new ActionResult<>(EnumActionResult.FAIL, itemstack);
//        }
//    }
//
//    @SubscribeEvent
//    public static void onPlayerFall(LivingFallEvent event) {
//        if (event.getEntityLiving() instanceof EntityPlayer) {
//            EntityPlayer player = (EntityPlayer) event.getEntityLiving();
//            ItemStack chestArmor = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
//
//            if (chestArmor.getItem() instanceof TestWings) {
//                if (!player.onGround && player.motionY < 0.0D) {
//                    try {
//                        Method setFlagMethod = Entity.class.getDeclaredMethod("setFlag", int.class, boolean.class);
//                        setFlagMethod.setAccessible(true);
//                        setFlagMethod.invoke(player, 7, true); // Activate elytra gliding
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
//    }
//}
//