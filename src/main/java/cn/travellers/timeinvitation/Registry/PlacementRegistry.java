package cn.travellers.timeinvitation.Registry;

import cn.travellers.timeinvitation.Utils;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PlacementRegistry {
    public static final DeferredRegister<Placement<?>> PLACEMENT = DeferredRegister.create(ForgeRegistries.DECORATORS, Utils.MOD_ID);
    //public static final Placement<ChanceConfig> VANITY_WATER_LAKE = register("vanity_water_lake", new LakeVanityWater(ChanceConfig.CODEC));
    public static <T extends IPlacementConfig, G extends Placement<T>> G register(String name, G placement){
        PLACEMENT.register(name, ()-> placement);
        return placement;
    }
}
