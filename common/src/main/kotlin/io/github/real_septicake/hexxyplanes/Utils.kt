package io.github.real_septicake.hexxyplanes

import at.petrak.hexcasting.api.casting.iota.Iota
import at.petrak.hexcasting.api.casting.mishaps.MishapInvalidIota
import at.petrak.hexcasting.api.casting.mishaps.MishapNotEnoughArgs
import io.github.real_septicake.hexxyplanes.casting.iota.PlaneIota

fun List<Iota>.getPlane(idx: Int, argc: Int = 0): PlaneIota {
    val x = this.getOrElse(idx) { throw MishapNotEnoughArgs(idx + 1, this.size) }
    if(x !is PlaneIota)
        throw MishapInvalidIota.ofType(x, if(argc == 0) idx else argc - (idx + 1), "plane")
    return x
}