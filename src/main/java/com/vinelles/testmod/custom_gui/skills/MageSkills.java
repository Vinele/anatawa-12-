package com.vinelles.testmod.custom_gui.skills;

import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class MageSkills {
    private static List<Skill> skills;

    public static List<Skill> getSkills() {
        if (skills == null) {
            skills = new ArrayList<>();
            skills.add(new Skill("Огненный шар", "Запускает огненный шар, наносящий урон врагам.", new ResourceLocation("minecraft", "textures/items/fireball.png"), 10, 2, 5));
            skills.add(new Skill("Ледяной осколок", "Выстреливает ледяным осколком, замедляющим врагов.", new ResourceLocation("minecraft", "textures/items/blaze_rod.png"), 15, 1, 3));
            skills.add(new Skill("Молния", "Вызывает удар молнии, наносящий урон и оглушающий врагов.", new ResourceLocation("minecraft", "textures/items/ghast_tear.png"), 20, 1, 4));
            skills.add(new Skill("Землетрясение", "Создает землетрясение, наносящее урон всем врагам в радиусе.", new ResourceLocation("minecraft", "textures/items/iron_shovel.png"), 25, 3, 6));
            skills.add(new Skill("Порыв ветра", "Создает порыв ветра, отбрасывающий врагов назад.", new ResourceLocation("minecraft", "textures/items/feather.png"), 5, 1, 2));
            skills.add(new Skill("Волна воды", "Вызывает волну воды, наносящую урон и замедляющую врагов.", new ResourceLocation("minecraft", "textures/items/feather.png"), 30, 2, 7));
            skills.add(new Skill("Теневой удар", "Наносит мощный удар из тени, увеличивая урон.", new ResourceLocation("minecraft", "textures/items/ender_pearl.png"), 35, 2, 8));
            skills.add(new Skill("Святой свет", "Восстанавливает здоровье союзникам в радиусе действия.", new ResourceLocation("minecraft", "textures/items/glowstone_dust.png"), 40, 2, 9));
            skills.add(new Skill("Тайный взрыв", "Вызывает магический взрыв, наносящий урон всем врагам в зоне действия.", new ResourceLocation("minecraft", "textures/items/dragon_breath.png"), 50, 3, 10));
            skills.add(new Skill("Метеоритный дождь", "Вызывает метеоритный дождь, наносящий массовый урон врагам.", new ResourceLocation("minecraft", "textures/items/nether_star.png"), 60, 4, 12));
            // Дополнительные скиллы
            skills.add(new Skill("Гроза", "Вызывает мощную грозу, наносящую значительный урон врагам.", new ResourceLocation("minecraft", "textures/items/diamond_sword.png"), 70, 5, 15));
            skills.add(new Skill("Метель", "Создает метель, наносящую урон и замедляющую врагов.", new ResourceLocation("minecraft", "textures/items/snowball.png"), 80, 4, 14));
        }
        return skills;
    }
}