package net.mandm.afmod.common.item;

import net.mandm.afmod.common.AFMod;
import net.mandm.afmod.common.item.custom.Blueprint;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AFMod.MOD_ID);
//    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot",
//            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> BLUEPRINT = ITEMS.register("blueprint",
        () -> new Blueprint(new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> EMPTY_BLUEPRINT = ITEMS.register("empty_blueprint",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
