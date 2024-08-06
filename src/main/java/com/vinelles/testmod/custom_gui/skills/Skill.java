package com.vinelles.testmod.custom_gui.skills;

import net.minecraft.util.ResourceLocation;
import java.util.ArrayList;
import java.util.List;

public class Skill {
    private final String name;
    private final String description;
    private final int manaCost;
    private final int castTime;
    private final int cooldown;
    private final ResourceLocation icon;

    public Skill(String name, String description, ResourceLocation icon, int manaCost, int castTime, int cooldown) {
        this.name = name;
        this.description = description;
        this.manaCost = manaCost;
        this.castTime = castTime;
        this.cooldown = cooldown;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getManaCost() {
        return manaCost;
    }

    public int getCastTime() {
        return castTime;
    }

    public int getCooldown() {
        return cooldown;
    }

    public ResourceLocation getIcon() {
        return icon;
    }

    public List<String> getTooltip() {
        List<String> tooltip = new ArrayList<>();
        tooltip.add(name);
        tooltip.add(description);
        tooltip.add("Мана: " + manaCost);
        tooltip.add("Применение: " + castTime);
        tooltip.add("Перезарядка: " + cooldown);
        return tooltip;
    }
}