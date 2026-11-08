package com.example.optreasure.client;

import com.example.optreasure.content.OpTreasureMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public final class OpTreasureScreen extends AbstractContainerScreen<OpTreasureMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("minecraft", "textures/gui/container/generic_54.png");
    public OpTreasureScreen(OpTreasureMenu menu, Inventory inventory, Component title) { super(menu, inventory, title); imageWidth = 176; imageHeight = 166; }
    @Override protected void renderBg(GuiGraphics graphics, float partialTick, int mouseX, int mouseY) { int x = (width - imageWidth) / 2; int y = (height - imageHeight) / 2; graphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight); }
    @Override public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) { renderBackground(graphics); super.render(graphics, mouseX, mouseY, partialTick); renderTooltip(graphics, mouseX, mouseY); }
}
