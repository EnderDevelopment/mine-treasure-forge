package com.example.optreasure;

import com.example.optreasure.command.OpTreasureCommands;
import com.example.optreasure.registry.ModBlockEntities;
import com.example.optreasure.registry.ModBlocks;
import com.example.optreasure.registry.ModMenus;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(OpTreasure.MOD_ID)
public final class OpTreasure {
    public static final String MOD_ID = "op_treasure";

    public OpTreasure() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModBlocks.BLOCKS.register(bus);
        ModBlocks.ITEMS.register(bus);
        ModBlockEntities.BLOCK_ENTITIES.register(bus);
        ModMenus.MENUS.register(bus);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void registerCommands(RegisterCommandsEvent event) {
        OpTreasureCommands.register(event);
    }
}
