package com.example.optreasure.command;

import com.example.optreasure.registry.ModBlocks;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.RegisterCommandsEvent;

public final class OpTreasureCommands {
    private OpTreasureCommands() {
    }

    public static void register(RegisterCommandsEvent event) {
        LiteralArgumentBuilder<CommandSourceStack> giveCommand = Commands.literal("give")
                .executes(context -> give(context.getSource(), context.getSource().getPlayerOrException(), 1))
                .then(Commands.argument("count", IntegerArgumentType.integer(1, 64))
                        .executes(context -> give(context.getSource(), context.getSource().getPlayerOrException(),
                                IntegerArgumentType.getInteger(context, "count"))))
                .then(Commands.argument("player", EntityArgument.player())
                        .executes(context -> give(context.getSource(), EntityArgument.getPlayer(context, "player"), 1))
                        .then(Commands.argument("count", IntegerArgumentType.integer(1, 64))
                                .executes(context -> give(context.getSource(), EntityArgument.getPlayer(context, "player"),
                                        IntegerArgumentType.getInteger(context, "count")))));

        event.getDispatcher().register(Commands.literal("op_treasure")
                .requires(source -> source.hasPermission(2))
                .then(giveCommand));
    }

    private static int give(CommandSourceStack source, ServerPlayer player, int count) {
        ItemStack stack = new ItemStack(ModBlocks.OP_TREASURE_CHEST.get(), count);
        boolean added = player.getInventory().add(stack);
        if (!added && !stack.isEmpty()) {
            player.drop(stack, false);
        }
        source.sendSuccess(() -> Component.translatable("commands.op_treasure.give.success", count, player.getDisplayName()), true);
        return count;
    }
}
