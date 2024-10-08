package com.vinelles.testmod.init;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.IRecipeFactory;

public class CraftingRegister {
    public static void register() {
        registerRecipes("key");
        registerRecipes("coconut");
    }

    private static void registerRecipes(String name) {
        CraftingHelper.register(new ResourceLocation("testmod", name), (IRecipeFactory) (context, json) -> CraftingHelper.getRecipe(json, context));
    }
}
