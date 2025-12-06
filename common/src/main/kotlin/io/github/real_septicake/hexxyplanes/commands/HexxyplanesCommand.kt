package io.github.real_septicake.hexxyplanes.commands

import com.mojang.brigadier.builder.LiteralArgumentBuilder
import net.minecraft.commands.CommandSourceStack

abstract class HexxyplanesCommand {
    abstract fun add(cmd: LiteralArgumentBuilder<CommandSourceStack>)
}