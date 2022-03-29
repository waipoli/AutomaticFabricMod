package net.mandm.afmod.common.block;

import net.mandm.afmod.common.AFMod;
import net.mandm.afmod.common.block.entity.AutomaticCraftingTableEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister
            .create(ForgeRegistries.BLOCK_ENTITIES, AFMod.MOD_ID);
    public static final RegistryObject<BlockEntityType<AutomaticCraftingTableEntity>> AUTOMATIC_CRAFTING_TABLE = BLOCK_ENTITIES
            .register("automatic_crafting_table", () -> BlockEntityType.Builder
                    .of(AutomaticCraftingTableEntity::new, ModBlocks.AUTOMATIC_CRAFTING_TABLE.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
