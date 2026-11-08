package com.example.optreasure.registry;

import com.example.optreasure.OpTreasure;
import com.example.optreasure.content.OpTreasureChestBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, OpTreasure.MOD_ID);
    public static final RegistryObject<BlockEntityType<OpTreasureChestBlockEntity>> OP_TREASURE_CHEST = BLOCK_ENTITIES.register("op_treasure_chest", () -> BlockEntityType.Builder.of(OpTreasureChestBlockEntity::new, ModBlocks.OP_TREASURE_CHEST.get()).build(null));

    private ModBlockEntities() { }
}
