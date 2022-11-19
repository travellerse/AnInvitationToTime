package cn.travellers.timeinvitation.Registry;

import cn.travellers.timeinvitation.Bimoe.TimeInvitationBiomeMaker;
import cn.travellers.timeinvitation.Utils;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeRegistry {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, Utils.MOD_ID);
    public static Biome AncientFernForest = register("ancient_fern_forest", TimeInvitationBiomeMaker.makeAncientFernForest(0.1F, 0.2F,0.9F,false,false));

    public static Biome register(String name,Biome biome){
        BIOMES.register(name, ()->biome);
        return biome;
    }
}
