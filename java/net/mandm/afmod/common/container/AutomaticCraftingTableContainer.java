package net.mandm.afmod.common.container;

import net.mandm.afmod.common.block.ModBlocks;
import net.mandm.afmod.common.block.custom.AutomaticCraftingTable;
import net.mandm.afmod.common.block.entity.AutomaticCraftingTableEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class AutomaticCraftingTableContainer extends AbstractContainerMenu {
    private final ContainerLevelAccess containerAccess;

    // Client Constructor
    public AutomaticCraftingTableContainer(int id, Inventory playerInventory) {
        this(id, playerInventory, new ItemStackHandler(1), BlockPos.ZERO);
    }

    // Server Constructor
    public AutomaticCraftingTableContainer(int id, Inventory playerInventory, IItemHandler slots, BlockPos pos) {
        super(ModContainers.AUTOMATIC_CRAFTING_TABLE.get(), id);
        this.containerAccess = ContainerLevelAccess.create(playerInventory.player.level, pos);

        final int slotSizePlus2 = 18, startX = 8, startY = 86, hotbarY = 144, invY = 18;
        addSlot(new SlotItemHandler(slots, 0,
                  80, 35));

        for (int column = 0;column < 9;column++) {
            for (int row = 0;row < 3;row++) {
                addSlot(new Slot(playerInventory, 9 + row * 9 + column,
                        startX + column * slotSizePlus2, startY + row * slotSizePlus2));
            }
        }

        for (int column = 0;column < 9;column++) {
            addSlot(new Slot(playerInventory, column, startX + column * slotSizePlus2, hotbarY));
        }
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        var retStack = ItemStack.EMPTY;
        final Slot slot = this.slots.get(index);
        if (slot.hasItem()) {
            final ItemStack stack = slot.getItem();
            retStack = stack.copy();

            final int size = this.slots.size() - player.getInventory().getContainerSize();
            if (index < size) {
                if (!moveItemStackTo(stack, 0, this.slots.size(), false))
                    return ItemStack.EMPTY;
            } else if (!moveItemStackTo(stack, 0, size, false))
                return ItemStack.EMPTY;

            if (stack.isEmpty() || stack.getCount() == 0) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (stack.getCount() == retStack.getCount())
                return ItemStack.EMPTY;

            slot.onTake(player, stack);
        }

        return retStack;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(containerAccess, player, ModBlocks.AUTOMATIC_CRAFTING_TABLE.get());
    }

    public static MenuConstructor getServerContainer(AutomaticCraftingTableEntity table, BlockPos pos) {
        return (id, playerInv, player) -> new AutomaticCraftingTableContainer(id, playerInv, table.inventory, pos);
    }
}
