package io.github.real_septicake.hexxyplanes

import at.petrak.hexcasting.api.casting.iota.Iota
import at.petrak.hexcasting.api.casting.mishaps.MishapInvalidIota
import at.petrak.hexcasting.api.casting.mishaps.MishapNotEnoughArgs
import io.github.real_septicake.hexxyplanes.casting.iota.PlaneIota
import net.minecraft.core.Vec3i
import net.minecraft.world.phys.Vec3

fun List<Iota>.getPlane(idx: Int, argc: Int = 0): PlaneIota {
    val x = this.getOrElse(idx) { throw MishapNotEnoughArgs(idx + 1, this.size) }
    if(x !is PlaneIota)
        throw MishapInvalidIota.ofType(x, if(argc == 0) idx else argc - (idx + 1), "plane")
    return x
}

fun Vec3.toVecI(): Vec3i {
    return Vec3i(this.x.toInt(), this.y.toInt(), this.z.toInt())
}