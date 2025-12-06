package io.github.real_septicake.hexxyplanes.commands

import com.mojang.brigadier.builder.LiteralArgumentBuilder
import io.github.real_septicake.hexxyplanes.HexxyplanesDimension
import net.minecraft.commands.CommandSourceStack
import net.minecraft.commands.Commands

object ExitPlaneCommand : HexxyplanesCommand() {
    override fun add(cmd: LiteralArgumentBuilder<CommandSourceStack>) {
        cmd.then(Commands.literal("exitPlane")
            .executes {
                HexxyplanesDimension.exitPlane(it.source.level, it.source.playerOrException)
                1
            }
        )
    }
}