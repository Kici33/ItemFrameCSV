package me.kici33.ItemFrame;

import me.kici33.ItemFrame.managers.ShopItemManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

    public static void loadCSV() {
        try {
            if(!IFrame.getInstance().getDataFolder().exists())
                IFrame.getInstance().getDataFolder().mkdir();
            File f = new File(IFrame.getInstance().getDataFolder(), "data.csv");
            if(!f.exists())
                f.createNewFile();
            BufferedReader reader = new BufferedReader(new FileReader(f));
            reader.lines().forEach(line -> {
                ShopItemManager.addShopItem(line.replace(",,", "").replaceAll("\"", "").split(","));
            });
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
