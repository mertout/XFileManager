package io.github.mertout;

import org.bukkit.plugin.java.JavaPlugin;

public class FileManager extends JavaPlugin {

    public static FileManager instance;
	private Manager manager;

    @Override
    public void onEnable() {
        instance = this;
		loadClass();
        getManager().writeFile("xyz", "123", "test", "data/x");
        System.out.println(getManager().getObjectFile("xyz", "test"));		
    }
    public void loadClass() {
        manager = new Manager();
    }
    public static FileManager getInstance() {
        return instance;
    }
    public Manager getManager() {
        return manager;
    }	
}
