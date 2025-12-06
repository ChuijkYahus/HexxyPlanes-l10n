package io.github.real_septicake.hexxyplanes.commands

import com.mojang.brigadier.builder.LiteralArgumentBuilder
import io.github.real_septicake.hexxyplanes.HexxyplanesDimension
import net.minecraft.commands.CommandSourceStack
import net.minecraft.commands.Commands
import net.minecraft.commands.arguments.EntityArgument

object EnterPlaneCommand : HexxyplanesCommand() {
    override fun add(cmd: LiteralArgumentBuilder<CommandSourceStack>) {
        cmd.then(Commands.literal("enterPlane")
            .then(Commands.argument("for", EntityArgument.player())
                .executes {
                    val p = EntityArgument.getPlayer(it, "for")
                    val world = it.source.server.getLevel(HexxyplanesDimension.WORLD_KEY) ?: return@executes 0
                    HexxyplanesDimension.goToPlane(world, it.source.playerOrException, p.uuid)
                    1
                }
            )
        )
    }
}