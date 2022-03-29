package net.mandm.afmod.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.mandm.afmod.common.AFMod;
import net.mandm.afmod.common.block.entity.AutomaticCraftingTableEntity;
import net.mandm.afmod.common.container.AutomaticCraftingTableContainer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.client.gui.widget.ExtendedButton;

public class AutomaticCraftingTableScreen extends AbstractContainerScreen<AutomaticCraftingTableContainer> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(AFMod.MOD_ID, "textures/gui/automatic_crafting_table.png");

    // private ExtendedButton button;

    public AutomaticCraftingTableScreen(AutomaticCraftingTableContainer container, Inventory playerInventory, Component title) {
        super(container, playerInventory, title);
        this.leftPos = 0;
        this.topPos = 0;
        this.imageWidth = 176;
        this.imageHeight = 168;
    }

    @Override
    protected void renderBg(PoseStack stack, float mouseX, int mouseY, int particalTicks) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        blit(stack, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
    }

    @Override
    protected void renderLabels(PoseStack stack, int mouseX, int mouseY) {
        //drawString(stack, this.font, this.title, this.leftPos + 8, this.topPos + 5, 0x404040);
        //drawString(stack, font, playerInventoryTitle, this.leftPos + 8, this.topPos + 73, 0x404040);
    }

    @Override
    protected void init() {
        super.init();
        //this.button = addRenderableWidget(new ExtendedButton(leftPos, topPos, 16, 16, new TextComponent("Click me"), btn ->{
        //    Minecraft.getInstance().player.displayClientMessage(new TextComponent("I`ve been clicked"), false);
        //}));
    }
}
