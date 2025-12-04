package io.github.real_septicake.hexxyplanes.fabric

import io.github.real_septicake.hexxyplanes.Hexxyplanes
import io.github.real_septicake.hexxyplanes.HexxyplanesCommands
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback

object FabricHexxyplanes : ModInitializer {
    override fun onInitialize() {
        Hexxyplanes.init()
        CommandRegistrationCallback.EVENT.register { dp, _, _ -> HexxyplanesCommands.register(dp) }
    }
}
