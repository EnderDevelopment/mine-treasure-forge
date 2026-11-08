package com.example.optreasure.content;

import com.example.optreasure.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraft.nbt.CompoundTag;

public final class OpTreasureChestBlockEntity extends BlockEntity implements MenuProvider {
    public final ItemStackHandler inventory = new ItemStackHandler(27);
    private final LazyOptional<IItemHandler> itemHandler = LazyOptional.of(() -> inventory);
    private boolean generated;

    public OpTreasureChestBlockEntity(BlockPos pos, BlockState state) { super(ModBlockEntities.OP_TREASURE_CHEST.get(), pos, state); }
    @Override public Component getDisplayName() { return Component.translatable("block.op_treasure.op_treasure_chest"); }
    @Override public AbstractContainerMenu createMenu(int id, Inventory playerInventory, Player player) { if (!generated) { TreasureGenerator.fill(inventory); generated = true; setChanged(); } return new OpTreasureMenu(id, playerInventory, this); }
    @Override protected void saveAdditional(CompoundTag tag) { super.saveAdditional(tag); tag.put("Inventory", inventory.serializeNBT()); tag.putBoolean("Generated", generated); }
    @Override public void load(CompoundTag tag) { super.load(tag); inventory.deserializeNBT(tag.getCompound("Inventory")); generated = tag.getBoolean("Generated"); }
    public LazyOptional<IItemHandler> getItemHandler() { return itemHandler; }
    @Override public void setRemoved() { super.setRemoved(); itemHandler.invalidate(); }
}
