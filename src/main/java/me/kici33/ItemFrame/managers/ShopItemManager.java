package me.kici33.ItemFrame.managers;

import me.kici33.ItemFrame.objects.ShopItem;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class ShopItemManager {

    private static ArrayList<ShopItem> itemy = new ArrayList<ShopItem>();

    public static void addShopItem(String[] csv) {
        itemy.add(new ShopItem(csv));
    }

    public static ShopItem isSpecified(ItemStack itemStack) {
        return itemy.stream().filter(shopItem -> shopItem.getID() == itemStack.getTypeId() && shopItem.getData() == itemStack.getData().getData()).findAny().orElse(null);
    }
}
