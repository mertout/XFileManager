package io.github.mertout;

import org.bukkit.plugin.java.JavaPlugin;

public class FileManager extends JavaPlugin {

    public static FileManager instance;
	private Manager manager;

    @Override
    public void onEnable() {
        instance = this;
		loadClass();
		getManager().writeFile("xyz"#path, "123"#to, "test"#file, "data/x")#file;
		System.out.println(getManager().getObjectFile("xyz"#path, "test"#file));
		getManager().nameToFile("settings").mkdirs();
		getManager().nameToFileCFG("settings").getString("settings.xyz");		
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
