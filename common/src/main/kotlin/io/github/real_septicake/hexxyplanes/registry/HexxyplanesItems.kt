package io.github.real_septicake.hexxyplanes.registry

import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.world.item.Item

object HexxyplanesItems : HexxyplanesRegistrar<Item>(
    Registries.ITEM,
    { BuiltInRegistries.ITEM }
)