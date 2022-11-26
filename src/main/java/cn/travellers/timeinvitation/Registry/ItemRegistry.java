package cn.travellers.timeinvitation.Registry;

import cn.travellers.timeinvitation.Utils;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Utils.MOD_ID);
    public static final RegistryObject<Item> oldVines = ITEMS.register("old_vines_item", () -> new BlockItem(BlockRegistry.oldVines, new Item.Properties().group(Utils.itemGroup)));
    public static final RegistryObject<BlockItem> fernStem = ITEMS.register("fern_stem_item",()-> new BlockItem(BlockRegistry.fernStem, new Item.Properties().group(Utils.itemGroup)));
    public static final RegistryObject<BlockItem> fernLeaves = ITEMS.register("fern_leaves_item",()-> new BlockItem(BlockRegistry.fernLeaves, new Item.Properties().group(Utils.itemGroup)));
    public static final RegistryObject<BlockItem> fernSeeds = ITEMS.register("fern_seeds_item",()-> new BlockItem(BlockRegistry.fernSeeds,new Item.Properties().group(Utils.itemGroup)));

}
