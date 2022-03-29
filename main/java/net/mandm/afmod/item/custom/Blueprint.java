package net.mandm.afmod.item.custom;

import net.minecraft.Util;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;

public class Blueprint extends Item {

    public Blueprint(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (!context.getLevel().isClientSide()) {
            context.getPlayer().sendMessage(new TextComponent("I`ve been used!"), Util.NIL_UUID);
        }
        return InteractionResult.SUCCESS;
    }
}
