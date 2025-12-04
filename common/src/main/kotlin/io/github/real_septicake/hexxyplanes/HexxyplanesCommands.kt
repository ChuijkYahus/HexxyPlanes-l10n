package io.github.real_septicake.hexxyplanes

import com.mojang.brigadier.CommandDispatcher
import io.github.real_septicake.hexxyplanes.commands.GenDemiplaneCommand
import net.minecraft.commands.CommandSourceStack
import net.minecraft.commands.Commands

object HexxyplanesCommands {
    fun register(dispatcher: CommandDispatcher<CommandSourceStack>) {
        val source = Commands.literal("hexxyplanes")

        GenDemiplaneCommand.add(source)

        dispatcher.register(source)
    }
}