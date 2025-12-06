@file:JvmName("HexxyplanesAbstractionsImpl")

package io.github.real_septicake.hexxyplanes.fabric

import io.github.real_septicake.hexxyplanes.registry.HexxyplanesRegistrar
import net.minecraft.core.Registry
import net.minecraft.server.level.ServerLevel

val planeCache = mutableMapOf<String, ServerLevel>()

fun <T : Any> initRegistry(registrar: HexxyplanesRegistrar<T>) {
    val registry = registrar.registry
    registrar.init { id, value -> Registry.register(registry, id, value) }
}