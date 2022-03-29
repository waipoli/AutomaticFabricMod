package net.mandm.afmod.common;

import net.mandm.afmod.common.block.ModBlockEntities;
import net.mandm.afmod.common.block.ModBlocks;
import net.mandm.afmod.common.container.ModContainers;
import net.mandm.afmod.common.item.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@net.minecraftforge.fml.common.Mod(AFMod.MOD_ID)
public class AFMod {
    public static final String MOD_ID = "afmod";

    public AFMod() {

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModBlockEntities.register(eventBus);
        ModContainers.register(eventBus);
        eventBus.addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }
}
