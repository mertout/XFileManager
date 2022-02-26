package filemanager.filemanager;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Manager {

    List<String> files = new ArrayList<>();

    File file;
    YamlConfiguration filecfg;

    public Manager(String... strlist) {
        for (String str : strlist) {
            file = new File(FileManager.getInstance().getDataFolder(), files + ".yml");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void writeFile(String str, Object to, String... folders) {
        for (String x : folders) {
            file = new File(FileManager.getInstance().getDataFolder(), x + ".yml");
            filecfg = YamlConfiguration.loadConfiguration(file);
            filecfg.set(str, to);
            try {
                filecfg.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public Object getObjectFile(String str, String folder) {
        file = new File(FileManager.getInstance().getDataFolder(), folder + ".yml");
        filecfg = YamlConfiguration.loadConfiguration(file);
        return filecfg.get(str);
    }
}
