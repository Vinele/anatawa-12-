package com.vinelles.testmod.init;

import com.vinelles.testmod.item.ItemAmmo;
import com.vinelles.testmod.item.ItemCoconut;

import com.vinelles.testmod.item.ItemKey;
import com.vinelles.testmod.item.armor.ItemMagicArmor;
import com.vinelles.testmod.item.block.BlockBestStone;
import com.vinelles.testmod.item.tools.*;
import com.vinelles.testmod.item.wings.DemonWings;
import com.vinelles.testmod.item.wings.ItemParachute;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemElytra;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

import static com.vinelles.testmod.init.CustomMaterials.ARMOR_MATERIAL;


/*
 * Указывает ModId для других ObjectHolder в классе
 * Если не добавлять аннотацию над классом, то каждый раз придётся прописывать ModId вручную.
 * Подробнее см. https://mcforge.readthedocs.io/en/latest/concepts/registries/#injecting-registry-values-into-fields
 */
@GameRegistry.ObjectHolder("testmod")
@Mod.EventBusSubscriber// Автоматическая регистрация статичных обработчиков событий
public class ItemsRegistry {
    /*
     * Получение предмета по ключу. Вы также можете использовать данную аннотацию для получения ванильных предметов
     * Если вы не добавляли аннотация над классом, то в таком случаи вам нужно прописать вместо `key` -> `tut:key`
     */





    //items
    public static final Item KEY = new ItemKey();
    public static final Item FROSTSTAFF = new FrostStaff();
    public static final Item AMMO = new ItemAmmo();
    public static final Item TEST_STAFF = new ItemTestStaff();
    public static final Item HEALBOOK = new HealBook();
    public static final Item AZZINOT = new Azzinot();
    public static final Item PARACHUTE = new ItemParachute();
    public static final Item WINGS = new DemonWings();





    //food
    public static final Item COCONUT = new ItemCoconut("coconut", 1, 100, false);

    //tools
    public static final Item MYPICKAXE = new ItemToolPickaxe("mypickaxe", CustomMaterials.TOOL_MATERIAL);
    public static final Item MYAXE = new ItemToolAxe("myaxe", CustomMaterials.TOOL_MATERIAL);



    public static final Item
            BOOTS = new ItemMagicArmor("orange_boots", ARMOR_MATERIAL, 1, EntityEquipmentSlot.FEET),
            LEGGS = new ItemMagicArmor("orange_leggings", ARMOR_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            CHESTPLATE = new ItemMagicArmor("orange_chestplate", ARMOR_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            HEAD = new ItemMagicArmor("orange_helmet", ARMOR_MATERIAL, 1, EntityEquipmentSlot.HEAD);



   //public static Block BEST_STONE = new BlockBestStone("best_stone");
   ////ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
   //public static Item BEST_STONE_ITEM = new ItemBlock(BEST_STONE).setRegistryName(BEST_STONE.getRegistryName());


    /*
     * Начиная с 1.12 регистрацию предметов/блоков/моделей и т.п. следует проводить в специальном событии.
     * Событие Register<IForgeRegistryEntry> поддерживает регистрацию: Block, Item, Potion, Biome, SoundEvent,
     * PotionType, Enchantment, IRecipe,  VillagerProfession, EntityEntry.
     * Обратите внимание! Метод является статичным, так как мы используем EventBusSubscriber
     */
    @SubscribeEvent
    public static void onRegistryItem(RegistryEvent.Register<Item> e) {
        // Также вместо `register` можно использовать `registerAll`, чтобы прописать все предметы разом
        e.getRegistry().register(KEY);
        e.getRegistry().register(COCONUT);
        e.getRegistry().register(MYPICKAXE);
        e.getRegistry().register(MYAXE);
        e.getRegistry().register(FROSTSTAFF);
        e.getRegistry().register(AMMO);
        e.getRegistry().register(TEST_STAFF);
        e.getRegistry().register(HEALBOOK);
        e.getRegistry().register(AZZINOT);
        e.getRegistry().register(PARACHUTE);
        e.getRegistry().register(WINGS);


        e.getRegistry().register(HEAD);
        e.getRegistry().register(LEGGS);
        e.getRegistry().register(CHESTPLATE);
        e.getRegistry().register(BOOTS);

        //e.getRegistry().register(BEST_STONE_ITEM);
    }

    /*
     * Начиная с 1.11 регистрацию моделей для предметов/блоков следует проводить в специальном событии.
     * Обратите внимание! Метод является статичным, так как мы используем EventBusSubscriber
     */
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onRegistryModel(ModelRegistryEvent e) {
        // См. следующую часть данной главы
        registryModel(KEY);
        registryModel(COCONUT);
        registryModel(MYPICKAXE);
        registryModel(MYAXE);
        registryModel(FROSTSTAFF);
        registryModel(AMMO);
        registryModel(TEST_STAFF);
        registryModel(HEALBOOK);
        registryModel(AZZINOT);
        registryModel(PARACHUTE);
        registryModel(WINGS);


        registryModel(HEAD);
        registryModel(LEGGS);
        registryModel(CHESTPLATE);
        registryModel(BOOTS);

        //registryModel(BEST_STONE_ITEM);
    }

    @SideOnly(Side.CLIENT)
    private static void registryModel(Item item) {
        final ResourceLocation regName = item.getRegistryName();// Не забываем, что getRegistryName может вернуть Null!
        final ModelResourceLocation mrl = new ModelResourceLocation(regName, "inventory");
        ModelBakery.registerItemVariants(item, mrl);// Регистрация вариантов предмета. Это нужно если мы хотим использовать подтипы предметов/блоков(см. статью подтипы)
        ModelLoader.setCustomModelResourceLocation(item, 0, mrl);// Устанавливаем вариант модели для нашего предмета. Без регистрации варианта модели, сама модель не будет установлена для предмета/блока(см. статью подтипы)
    }
}
