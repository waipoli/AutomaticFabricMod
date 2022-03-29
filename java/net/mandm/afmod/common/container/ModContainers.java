package net.mandm.afmod.common.container;

import net.mandm.afmod.common.AFMod;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModContainers {
    private ModContainers() {
    }

    public static final DeferredRegister<MenuType<?>> CONTAINERS =
            DeferredRegister.create(ForgeRegistries.CONTAINERS, AFMod.MOD_ID);

    public static final RegistryObject<MenuType<AutomaticCraftingTableContainer>> AUTOMATIC_CRAFTING_TABLE = CONTAINERS
            .register("automatic_crafting_table", () -> new MenuType<>(AutomaticCraftingTableContainer::new));

    public static void register(IEventBus eventBus) {
        CONTAINERS.register(eventBus);
    }
}
