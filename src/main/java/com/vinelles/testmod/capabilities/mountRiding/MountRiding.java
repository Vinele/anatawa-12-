package com.vinelles.testmod.capabilities.mountRiding;

public class MountRiding implements IMountRiding {
    private int mountRidingSkill = 0;

    @Override
    public void set(int points) {
        if (points < 0){
            mountRidingSkill = 0;
            return;
        }

        if (points > 4)
        {
            mountRidingSkill = 4;
            return;
        }

        mountRidingSkill = points;
    }

    @Override
    public void upgrade() {
        if(mountRidingSkill+1 > 4)
        {
            return;
        }

        mountRidingSkill += 1;
    }

    @Override
    public int get() {
        return mountRidingSkill;
    }

}
