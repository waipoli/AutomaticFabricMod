package net.mandm.mod.item;

import net.mandm.mod.AFMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AFMod.MOD_ID);
//    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot",
//            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
