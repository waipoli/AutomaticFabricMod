package net.mandm.afmod.common.block.entity;

import net.mandm.afmod.common.AFMod;
import net.mandm.afmod.common.block.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.block.state.BlockState;

public class AutomaticCraftingTableEntity extends InventoryBlockEntity{
    public static final Component TITLE = new TranslatableComponent("container." + AFMod.MOD_ID + ".automatic_crafting_table");

    public AutomaticCraftingTableEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.AUTOMATIC_CRAFTING_TABLE.get(), pos, state, 1);
    }
}
