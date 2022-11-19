package cn.travellers.timeinvitation.Registry;

import cn.travellers.timeinvitation.Utils;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FeatureRegistry {
    public static final DeferredRegister<Feature<?>> FEATURE = DeferredRegister.create(ForgeRegistries.FEATURES, Utils.MOD_ID);
    //public static final Feature<BlockStateFeatureConfig> VANITY_IN_LAKE = register("vanity_in_lake",new VanityLakesFeature(BlockStateFeatureConfig.CODEC));

    public static <FC extends IFeatureConfig> Feature<FC> register(String name, Feature<FC> feature){
        System.out.println("create Feature.");
        FEATURE.register(name, ()-> feature);
        return feature;
    }
}
