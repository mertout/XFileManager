package io.github.mertout.filemanager;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Manager {

    File file;
    YamlConfiguration filecfg;

    public void writeFile(String str, String to, String... files) {
        for (String x : files) {
            file = new File(getInstance().getDataFolder(), x + ".yml");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            filecfg = YamlConfiguration.loadConfiguration(file);
            filecfg.set(str, to);
            try {
                filecfg.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public String getObjectFile(String str, String files) {
        file = new File(getInstance().getDataFolder(), files + ".yml");
        if (!file.exists()) return null;
        filecfg = YamlConfiguration.loadConfiguration(file);
        return (String) filecfg.get(str);
    }
    public File nameToFile(String files) {
        file = new File(getInstance().getDataFolder(), files + ".yml");
        if (!file.exists()) return null;
        return file;
    }
    public YamlConfiguration nameToFileCFG(String files) {
        file = new File(getInstance().getDataFolder(), files + ".yml");
        if (!file.exists()) return null;
        filecfg = YamlConfiguration.loadConfiguration(file);
        return filecfg;
    }
    public void reloadCFG(String files) {
        file = new File(getInstance().getDataFolder(), files + ".yml");
        filecfg = YamlConfiguration.loadConfiguration(file);
    }
    public boolean isExistsCFG(String files) {
        file = new File(getInstance().getDataFolder(), files + ".yml");
        return file.exists();
    }
}
