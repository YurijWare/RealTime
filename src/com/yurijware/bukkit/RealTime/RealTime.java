package com.yurijware.bukkit.RealTime;

import java.io.*;
import java.util.logging.Logger;

import org.bukkit.Server;
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
	protected RTTimeThread thread = null;
	
	private int repeatTime = 20;
	
	public RealTime(PluginLoader pluginLoader, Server instance,
			PluginDescriptionFile desc, File folder, File plugin,
			ClassLoader cLoader) throws IOException {
		super(pluginLoader, instance, desc, folder, plugin, cLoader);
	}
	
	public void onEnable() {
		plugin = this;
		pdfFile = this.getDescription();
		thread = new RTTimeThread(this.getServer().getWorlds());
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
