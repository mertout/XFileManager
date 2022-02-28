package filemanager.filemanager;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Manager {

    File file;
    YamlConfiguration filecfg;

    public void writeFile(String str, Object to, String... files) {
        for (String x : files) {
            file = new File(Bridge.getInstance().getDataFolder(), x + ".yml");
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
    public Object getObjectFile(String str, String files) {
        file = new File(Bridge.getInstance().getDataFolder(), files + ".yml");
        if (!file.exists()) return null;
        filecfg = YamlConfiguration.loadConfiguration(file);
        return filecfg.get(str);
    }
    public File nameToFile(String files) {
        file = new File(Bridge.getInstance().getDataFolder(), files + ".yml");
        if (!file.exists()) return null;
        return file;
    }
    public YamlConfiguration nameToFileCFG(String files) {
        file = new File(Bridge.getInstance().getDataFolder(), files + ".yml");
        if (!file.exist()) return null;
        filecfg = YamlConfiguration.loadConfiguration(file);
        return filecfg;
    }
}
