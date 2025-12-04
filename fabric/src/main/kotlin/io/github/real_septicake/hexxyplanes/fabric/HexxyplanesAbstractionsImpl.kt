@file:JvmName("HexxyplanesAbstractionsImpl")

package io.github.real_septicake.hexxyplanes.fabric

import com.mojang.logging.LogUtils
import io.github.real_septicake.hexxyplanes.Hexxyplanes
import io.github.real_septicake.hexxyplanes.registry.HexxyplanesRegistrar
import net.minecraft.core.Registry
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.server.level.ServerLevel
import net.minecraft.world.level.biome.Biomes
import xyz.nucleoid.fantasy.Fantasy
import xyz.nucleoid.fantasy.RuntimeWorldConfig
import xyz.nucleoid.fantasy.util.VoidChunkGenerator

val planeCache = mutableMapOf<String, ServerLevel>()

val LOGGER = LogUtils.getLogger()

fun <T : Any> initRegistry(registrar: HexxyplanesRegistrar<T>) {
    val registry = registrar.registry
    registrar.init { id, value -> Registry.register(registry, id, value) }
}

fun getOrMakeDim(world: ServerLevel, id: ResourceLocation) {
    LOGGER.info("Generating for ${id.path}")
    planeCache.computeIfAbsent(id.path) {
        val demiplane = world.server.registryAccess().lookupOrThrow(Registries.DIMENSION_TYPE)
            .getOrThrow(ResourceKey.create(Registries.DIMENSION_TYPE, Hexxyplanes.DEMIPLANE_RL))
        val config = RuntimeWorldConfig()
            .setDimensionType(demiplane)
            .setGenerator(VoidChunkGenerator(world.server.registryAccess().lookupOrThrow(Registries.BIOME)
                .getOrThrow(Biomes.THE_VOID)))
        Fantasy.get(world.server).getOrOpenPersistentWorld(id, config).asWorld()
    }
}