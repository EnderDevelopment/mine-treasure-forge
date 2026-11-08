package com.example.optreasure.registry;

import com.example.optreasure.OpTreasure;
import com.example.optreasure.content.OpTreasureChestBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, OpTreasure.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, OpTreasure.MOD_ID);

    public static final RegistryObject<Block> OP_TREASURE_CHEST = BLOCKS.register("op_treasure_chest", () -> new OpTreasureChestBlock(BlockBehaviour.Properties.of().strength(3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Item> OP_TREASURE_CHEST_ITEM = ITEMS.register("op_treasure_chest", () -> new BlockItem(OP_TREASURE_CHEST.get(), new Item.Properties()));

    private ModBlocks() { }
}
