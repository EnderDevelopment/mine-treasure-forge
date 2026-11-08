package com.example.optreasure.registry;

import com.example.optreasure.OpTreasure;
import com.example.optreasure.content.OpTreasureMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModMenus {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, OpTreasure.MOD_ID);
    public static final RegistryObject<MenuType<OpTreasureMenu>> OP_TREASURE_CHEST = MENUS.register("op_treasure_chest", () -> IForgeMenuType.create(OpTreasureMenu::new));

    private ModMenus() { }
}
