package io.github.real_septicake.hexxyplanes

import at.petrak.hexcasting.api.casting.eval.CastingEnvironment
import at.petrak.hexcasting.api.casting.eval.CastingEnvironmentComponent
import io.github.real_septicake.hexxyplanes.Hexxyplanes.chunkFromUUID
import io.github.real_septicake.hexxyplanes.HexxyplanesDimension.PLANE_SIZE
import io.github.real_septicake.hexxyplanes.HexxyplanesDimension.WORLD_KEY
import net.minecraft.server.level.ServerPlayer
import net.minecraft.world.phys.Vec3

class HexplaneComponent(val env: CastingEnvironment) : CastingEnvironmentComponent.IsVecInRange {
    override fun getKey() = KEY()
    class KEY : CastingEnvironmentComponent.Key<CastingEnvironmentComponent.IsVecInRange>

    override fun onIsVecInRange(vec: Vec3?, current: Boolean): Boolean {
        if (env.world.dimension() === WORLD_KEY) {
            if (env.castingEntity is ServerPlayer) {
                val chunkPos = chunkFromUUID((env.castingEntity as ServerPlayer).uuid)
                val inside =
                    vec!!.x >= chunkPos.minBlockX && vec.x <= chunkPos.minBlockX + PLANE_SIZE &&
                            vec.z >= chunkPos.minBlockZ && vec.z <= chunkPos.minBlockZ + PLANE_SIZE &&
                            vec.y >= 0 && vec.y <= PLANE_SIZE
                return inside
            }
        }
        return current
    }
}