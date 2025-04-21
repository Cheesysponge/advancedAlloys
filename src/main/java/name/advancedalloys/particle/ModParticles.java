package name.advancedalloys.particle;
import name.advancedalloys.AdvancedAlloys;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
public class ModParticles {
    public static final DefaultParticleType  GUARDIAN_SWEEP_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType  GUARDIAN_CRIT_PARTICLE = FabricParticleTypes.simple();





    public static void registerParticles() {
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(AdvancedAlloys.MOD_ID, "guardian_sweep_particle"),
                GUARDIAN_SWEEP_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(AdvancedAlloys.MOD_ID, "guardian_damage_particle"),
                GUARDIAN_CRIT_PARTICLE);
    }
}
