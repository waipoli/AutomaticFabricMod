package net.mandm.afmod.events;

import net.mandm.afmod.client.screen.AutomaticCraftingTableScreen;
import net.mandm.afmod.common.AFMod;
import net.mandm.afmod.common.container.ModContainers;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = AFMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientModEvents {
    private ClientModEvents() {

    }

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        MenuScreens.register(ModContainers.AUTOMATIC_CRAFTING_TABLE.get(), AutomaticCraftingTableScreen::new);
    }
}
