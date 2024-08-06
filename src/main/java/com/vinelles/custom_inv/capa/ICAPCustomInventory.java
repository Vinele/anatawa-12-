package com.vinelles.custom_inv.capa;

import com.vinelles.custom_inv.CustomInventory;

public interface ICAPCustomInventory {

    public void copyInventory(ICAPCustomInventory inventory);
    public CustomInventory getInventory();
}