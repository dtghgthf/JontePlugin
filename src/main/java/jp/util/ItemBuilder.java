package jp.util;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ItemBuilder {

    private ItemStack item;
    private ItemMeta itemMeta;


    public ItemBuilder(Material material, short subID) {

        item = new ItemStack(material, 1, subID);
        itemMeta = item.getItemMeta();

    }

    public ItemBuilder(Material material) {

        this(material, (short) 0);

    }

    public ItemBuilder setName(String name) {

        itemMeta.setDisplayName(name);
        return this;
    }

    public ItemBuilder setLore(String... lore) {

        itemMeta.setLore(Arrays.asList(lore));
        return this;

    }

    public ItemBuilder setAmout(int amount) {

        item.setAmount(amount);
        return this;

    }

    public ItemStack build() {

        item.setItemMeta(itemMeta);
        return item;

    }

}
