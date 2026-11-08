package com.example.optreasure.content;

import com.example.optreasure.registry.ModMenus;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.SlotItemHandler;

public final class OpTreasureMenu extends AbstractContainerMenu {
    private final OpTreasureChestBlockEntity chest;
    public OpTreasureMenu(int id, Inventory playerInventory, FriendlyByteBuf data) { this(id, playerInventory, (OpTreasureChestBlockEntity) playerInventory.player.level().getBlockEntity(data.readBlockPos())); }
    public OpTreasureMenu(int id, Inventory playerInventory, OpTreasureChestBlockEntity chest) {
        super(ModMenus.OP_TREASURE_CHEST.get(), id); this.chest = chest;
        for (int row = 0; row < 3; row++) for (int col = 0; col < 9; col++) addSlot(new SlotItemHandler(chest.inventory, col + row * 9, 8 + col * 18, 18 + row * 18));
        for (int row = 0; row < 3; row++) for (int col = 0; col < 9; col++) addSlot(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
        for (int col = 0; col < 9; col++) addSlot(new Slot(playerInventory, col, 8 + col * 18, 142));
    }
    @Override public ItemStack quickMoveStack(Player player, int index) { Slot source = slots.get(index); if (!source.hasItem()) return ItemStack.EMPTY; ItemStack copy = source.getItem().copy(); int targetStart = index < 27 ? 27 : 0; int targetEnd = index < 27 ? slots.size() : 27; if (!moveItemStackTo(source.getItem(), targetStart, targetEnd, false)) return ItemStack.EMPTY; source.setChanged(); return copy; }
    @Override public boolean stillValid(Player player) { return chest.getBlockPos().closerToCenterThan(player.position(), 8.0D); }
}
