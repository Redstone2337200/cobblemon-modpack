package net.redstone233.cobblemon.modpack.commands;

import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.redstone233.cobblemon.modpack.datamod.ModGlobal;

public class InfoCommand {

    private static String[] texts = ModGlobal.TextModGlobal.GLOBAL_TEXTS;
    private static String[] books = ModGlobal.TextModGlobal.GLOBAL_BOOKS;

    private static String[] flydragons = ModGlobal.TeamModGlobal.Flydragons_Team;
    private static String[] trsmteams = ModGlobal.TeamModGlobal.TRS_TEAM;
    private static String[] jointteams = ModGlobal.TeamModGlobal.Joint_Team;

    public static LiteralArgumentBuilder<ServerCommandSource> register() {
        return CommandManager.literal("info").requires(src -> src.hasPermissionLevel(2))
        .then(CommandManager.literal("text")
            .then(CommandManager.argument("value",BoolArgumentType.bool())
                .executes(run -> InfoText(run.getSource(), 
                    BoolArgumentType.getBool(run, "value"), run.getSource().getPlayer())
                )
            )
        )
            .then(CommandManager.literal("book")
                .then(CommandManager.argument("value", BoolArgumentType.bool())
                    .executes(run -> BookText(run.getSource(), 
                        BoolArgumentType.getBool(run, "value"),run.getSource().getPlayer())
                    )
                )
            )
            .then(CommandManager.literal("team")
                .then(CommandManager.literal("flydragons")
                    .then(CommandManager.argument("value", BoolArgumentType.bool())
                        .executes(run -> TeamFlydragon(run.getSource(), 
                            BoolArgumentType.getBool(run, "value"), run.getSource().getPlayer())
                        )
                    )
                )
                    .then(CommandManager.literal("trsm")
                        .then(CommandManager.argument("value", BoolArgumentType.bool())
                            .executes(run -> TrsmTeam(run.getSource(), 
                                BoolArgumentType.getBool(run, "value"), run.getSource().getPlayer())
                            )
                        )
                    )
                    .then(CommandManager.literal("joint")
                        .then(CommandManager.argument("value", BoolArgumentType.bool())
                            .executes(run -> JointTeam(run.getSource(),
                                BoolArgumentType.getBool(run, "value"), run.getSource().getPlayer())
                        )
                    )
                )
            );
    }

    private static int InfoText(ServerCommandSource source,boolean value,PlayerEntity player) throws CommandSyntaxException {
        for (int i = 0; i < texts.length; i++) {
            if (player == null) {
                source.sendError(Text.translatable("commands.info.fail"));
                return 0;
            } else if (value == true) {
                player.sendMessage(Text.translatable("commands.info.text.success",texts[i],texts[1],texts[2]));
                source.sendFeedback(() -> Text.translatable("commands.info.success"), false);
                return 1;
            } else if (value == false) {
                source.sendFeedback(() -> Text.translatable("commands.info.success"), false);
                return 1;
            }
        }
        source.sendFeedback(() -> Text.translatable("commands.info.success"), false);
        return 1;
    }

    private static int BookText(ServerCommandSource source,boolean value,PlayerEntity player) throws CommandSyntaxException {
        for (int i = 0; i < books.length; i++) {
            if (player == null) {
                source.sendError(Text.translatable("commands.info.fail"));
                return 0;
            } else if (value == true) {
                player.sendMessage(Text.translatable("commands.info.book.success",books[i],books[1],books[2]));
                source.sendFeedback(() -> Text.translatable("commands.info.success"), false);
                return 1;
            } else if (value == false) {
                source.sendFeedback(() -> Text.translatable("commands.info.success"), false);
                return 1;
            }
        }
        source.sendFeedback(() -> Text.translatable("commands.info.success"), false);
        return 1;
    }

    private static int TeamFlydragon(ServerCommandSource source,boolean value,PlayerEntity player) throws CommandSyntaxException {
        for (int i = 0; i < flydragons.length; i++) {
            if (player == null) {
                source.sendError(Text.translatable("commands.info.fail"));
                return 0;
            } else if (value == true) {
                player.sendMessage(Text.translatable("commands.info.flydragon.success",flydragons[i]));
                source.sendFeedback(() -> Text.translatable("commands.info.success"), false);
                return 1;
            } else if (value == false) {
                source.sendFeedback(() -> Text.translatable("commands.info.success"), false);
                return 1;
            }
        }
        source.sendFeedback(() -> Text.translatable("commands.info.success"), false);
        return 1;
    }

    private static int TrsmTeam(ServerCommandSource source,boolean value,PlayerEntity player) throws CommandSyntaxException {
        for (int i = 0; i < trsmteams.length; i++) {
            if (player == null) {
                source.sendError(Text.translatable("commands.info.fail"));
                return 0;
            } else if (value == true) {
                player.sendMessage(Text.translatable("commands.info.trsm.success",trsmteams[i],trsmteams[1],trsmteams[2]));
                source.sendFeedback(() -> Text.translatable("commands.info.success"), false);
                return 1;
            } else if (value == false) {
                source.sendFeedback(() -> Text.translatable("commands.info.success"), false);
                return 1;
            }
        }
        source.sendFeedback(() -> Text.translatable("commands.info.success"), false);
        return 1;
    }

    private static int JointTeam(ServerCommandSource source,boolean value,PlayerEntity player) throws CommandSyntaxException {
        for (int i = 0; i < jointteams.length; i++) {
            if (player == null) {
                source.sendError(Text.translatable("commands.info.fail"));
                return 0;
            } else if (value == true) {
                player.sendMessage(Text.translatable("commands.info.joint.success",jointteams[i],jointteams[1],jointteams[2],jointteams[3]));
                source.sendFeedback(() -> Text.translatable("commands.info.success"), false);
                return 1;
            } else if (value == false) {
                source.sendFeedback(() -> Text.translatable("commands.info.success"), false);
                return 1;
            }
        }
        source.sendFeedback(() -> Text.translatable("commands.info.success"), false);
        return 1;
    }
}
