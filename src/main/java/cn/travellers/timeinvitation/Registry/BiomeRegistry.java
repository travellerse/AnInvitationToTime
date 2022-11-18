package cn.travellers.timeinvitation.Registry;

import cn.travellers.timeinvitation.Utils;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeRegistry {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, Utils.MOD_ID);
    //public static Biome vanityLake = register("vanity_lake",VanityBiomeMaker.makeVanityLakeBiome());

    public static Biome register(String name,Biome biome){
        BIOMES.register(name, ()->biome);
        return biome;
    }
}
