package io.github.real_septicake.hexxyplanes.fabric

import io.github.real_septicake.hexxyplanes.Hexxyplanes
import io.github.real_septicake.hexxyplanes.HexxyplanesCommands
import io.github.real_septicake.hexxyplanes.VoidChunkGenerator
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries

object FabricHexxyplanes : ModInitializer {

    override fun onInitialize() {
        Registry.register(BuiltInRegistries.CHUNK_GENERATOR, Hexxyplanes.id("void"), VoidChunkGenerator.CODEC)
        Hexxyplanes.init()
        CommandRegistrationCallback.EVENT.register { dp, _, _ -> HexxyplanesCommands.register(dp) }
    }
}
