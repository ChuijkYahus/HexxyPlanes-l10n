package io.github.real_septicake.hexxyplanes.fabric;

import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import dev.onyxstudios.cca.api.v3.entity.RespawnCopyStrategy;
import io.github.real_septicake.hexxyplanes.Hexxyplanes;

public final class HexxyplanesComponents implements EntityComponentInitializer {
    public static final ComponentKey<DemiplaneExitComponent> EXIT = ComponentRegistry.getOrCreate(
            Hexxyplanes.id("exit"), DemiplaneExitComponent.class
    );

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.registerForPlayers(EXIT, it -> new DemiplaneExitComponent(), RespawnCopyStrategy.ALWAYS_COPY);
    }
}
