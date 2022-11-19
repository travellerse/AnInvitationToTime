package cn.travellers.timeinvitation.Registry;

import cn.travellers.timeinvitation.Utils;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FluidRegistry {
    //public static final ResourceLocation STILL_OIL_TEXTURE = new ResourceLocation("block/water_still");
    //public static final ResourceLocation FLOWING_OIL_TEXTURE = new ResourceLocation("block/water_flow");

    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, Utils.MOD_ID);
    //public static final RegistryObject<FlowingFluid> vanityWaterFluid = FLUIDS.register("vanity_water_fluid", () -> new VanityWaterFluid(FluidRegistry.PROPERTIES));
    //public static final RegistryObject<FlowingFluid> vanityWaterFluidFlowing = FLUIDS.register("vanity_water_fluid_flowing", () -> new VanityWaterFluidFlowing(FluidRegistry.PROPERTIES));
    //public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(vanityWaterFluid, vanityWaterFluidFlowing, FluidAttributes.builder(STILL_OIL_TEXTURE, FLOWING_OIL_TEXTURE).color(0xFFC095F6).density(4000).viscosity(4000)).bucket(ItemRegistry.vanityWaterFluidBucket).block(()->BlockRegistry.vanityWater).slopeFindDistance(3).explosionResistance(100F);

}
