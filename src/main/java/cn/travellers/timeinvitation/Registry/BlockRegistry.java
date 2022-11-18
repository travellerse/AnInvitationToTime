package cn.travellers.timeinvitation.Registry;

import cn.travellers.timeinvitation.Block.OldVineBlock;
import cn.travellers.timeinvitation.Block.OldVineTopBlock;
import cn.travellers.timeinvitation.Utils;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Utils.MOD_ID);
    public static final Block oldVine = register("old_vine",new OldVineTopBlock(AbstractBlock.Properties.create(Material.PLANTS, MaterialColor.NETHERRACK).tickRandomly().doesNotBlockMovement().zeroHardnessAndResistance().sound(SoundType.NETHER_VINE)));
    public static final Block oldVinePlant = register("old_vine_plant",new OldVineBlock(AbstractBlock.Properties.create(Material.PLANTS, MaterialColor.NETHERRACK).tickRandomly().doesNotBlockMovement().zeroHardnessAndResistance().sound(SoundType.NETHER_VINE)));

    public static <T extends Block> T register(String name,T block){
        BLOCKS.register(name,()->block);
        return block;
    }
}
