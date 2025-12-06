@file:JvmName("HexxyplanesAbstractionsImpl")

package io.github.real_septicake.hexxyplanes.forge

import io.github.real_septicake.hexxyplanes.registry.HexxyplanesRegistrar
import net.minecraft.server.level.ServerLevel
import net.minecraftforge.registries.RegisterEvent
import thedarkcolour.kotlinforforge.forge.MOD_BUS

val planeCache = mutableMapOf<String, ServerLevel>()

fun <T : Any> initRegistry(registrar: HexxyplanesRegistrar<T>) {
    MOD_BUS.addListener { event: RegisterEvent ->
        event.register(registrar.registryKey) { helper ->
            registrar.init(helper::register)
        }
    }
}
