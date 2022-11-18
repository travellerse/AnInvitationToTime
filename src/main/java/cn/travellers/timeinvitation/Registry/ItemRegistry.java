package cn.travellers.timeinvitation.Registry;

import cn.travellers.timeinvitation.Utils;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Utils.MOD_ID);
    public static final RegistryObject<Item> oldVine = ITEMS.register("vanity_kelp_item", () -> new BlockItem(BlockRegistry.oldVine, new Item.Properties().group(Utils.itemGroup)));


}
