package cn.travellers.timeinvitation.Registry;

import cn.travellers.timeinvitation.Block.OldVineBlock;
import cn.travellers.timeinvitation.Block.OldVineTopBlock;
import cn.travellers.timeinvitation.Utils;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Utils.MOD_ID);
    public static final Block oldVine = register("old_vine",new OldVineTopBlock(AbstractBlock.Properties.create(Material.PLANTS).tickRandomly().doesNotBlockMovement().zeroHardnessAndResistance().sound(SoundType.NETHER_VINE)));
    public static final Block oldVinePlant = register("old_vine_plant",new OldVineBlock(AbstractBlock.Properties.create(Material.PLANTS).tickRandomly().doesNotBlockMovement().zeroHardnessAndResistance().sound(SoundType.NETHER_VINE)));
    public static final Block fernStem = register("fern_stem",new Block(AbstractBlock.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Block fernLeaves = register("fern_leaves",createLeavesBlock());

    public static <T extends Block> T register(String name,T block){
        BLOCKS.register(name,()->block);
        return block;
    }

    private static LeavesBlock createLeavesBlock() {
        return new LeavesBlock(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid().setAllowsSpawn(BlockRegistry::allowsSpawnOnLeaves).setSuffocates(BlockRegistry::isntSolid).setBlocksVision(BlockRegistry::isntSolid));
    }

    private static Boolean allowsSpawnOnLeaves(BlockState state, IBlockReader reader, BlockPos pos, EntityType<?> entity) {
        return entity == EntityType.OCELOT || entity == EntityType.PARROT;
    }
    private static boolean isntSolid(BlockState state, IBlockReader reader, BlockPos pos) {
        return false;
    }

}
