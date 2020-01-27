package me.kici33.ItemFrame;

import me.kici33.ItemFrame.commands.LoadSigns;
import org.bukkit.plugin.java.JavaPlugin;

public class IFrame extends JavaPlugin {
    private static IFrame instance;

    public void onEnable() {
        instance = this;

        CSVReader.loadCSV();
        getCommand("loadsigns").setExecutor(new LoadSigns());

    }

    public static IFrame getInstance() {
        return instance;
    }
}
