package io.github.real_septicake.hexxyplanes

import com.mojang.brigadier.CommandDispatcher
import io.github.real_septicake.hexxyplanes.commands.CreatePlaneCommand
import io.github.real_septicake.hexxyplanes.commands.EnterPlaneCommand
import io.github.real_septicake.hexxyplanes.commands.ExitPlaneCommand
import io.github.real_septicake.hexxyplanes.commands.GetChunkCommand
import net.minecraft.commands.CommandSourceStack
import net.minecraft.commands.Commands

object HexxyplanesCommands {
    fun register(dispatcher: CommandDispatcher<CommandSourceStack>) {
        val source = Commands.literal("hexxyplanes")

        GetChunkCommand.add(source)
        CreatePlaneCommand.add(source)
        EnterPlaneCommand.add(source)
        ExitPlaneCommand.add(source)

        dispatcher.register(source)
    }
}