package com.vinelles.testmod.custom_gui.skills;

import java.util.ArrayList;
import java.util.List;

public class ActiveSkillsManager {

    private static final List<Skill> activeSkills = new ArrayList<>();

    public static List<Skill> getActiveSkills() {
        return activeSkills;
    }

    // Добавляем метод для проверки, активен ли скилл
    public static boolean hasSkill(Skill skill) {
        return activeSkills.contains(skill);
    }

    public static void addSkill(Skill skill) {
        if (!activeSkills.contains(skill)) {
            activeSkills.add(skill);
        }
    }

    public static void removeSkill(Skill skill) {
        activeSkills.remove(skill);
    }
}