package com.yurijware.bukkit.RealTime;

import java.io.*;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

/**
 * RealTime for Bukkit
 * Main class
 * 
 * @author Yurij
 */
public class RealTime extends JavaPlugin {
	private final Logger log = Logger.getLogger("Minecraft");
	protected static PluginDescriptionFile pdfFile = null;
	protected static RealTime plugin = null;
	protected static List<World> worlds = null;
	protected RTTimeThread thread = new RTTimeThread("RealTime");
	
	private int repeatTime = 10;
	
	public RealTime(PluginLoader pluginLoader, Server instance,
			PluginDescriptionFile desc, File folder, File plugin,
			ClassLoader cLoader) throws IOException {
		super(pluginLoader, instance, desc, folder, plugin, cLoader);
	}
	
	public void onEnable() {
		plugin = this;
		worlds = this.getServer().getWorlds();
		pdfFile = this.getDescription();
		BukkitScheduler scheduler = this.getServer().getScheduler();
		scheduler.scheduleSyncRepeatingTask(this, thread, 0, repeatTime * 20);
		
		log.info("[" + pdfFile.getName() + "] Version "
				+ pdfFile.getVersion() + " is enabled!");
	}
	
	public void onDisable() {
		log.info("[" + pdfFile.getName() + "] "
				+ "Plugin is disabled!");
	}
	
}
