package io.github.real_septicake.hexxyplanes.registry

import at.petrak.hexcasting.api.casting.iota.IotaType
import at.petrak.hexcasting.common.lib.HexRegistries
import at.petrak.hexcasting.common.lib.hex.HexIotaTypes
import io.github.real_septicake.hexxyplanes.casting.iota.PlaneIota

object HexxyplanesIotas : HexxyplanesRegistrar<IotaType<*>>(
    HexRegistries.IOTA_TYPE,
    { HexIotaTypes.REGISTRY }
) {
    val PLANE = register("plane") { PlaneIota.TYPE }
}