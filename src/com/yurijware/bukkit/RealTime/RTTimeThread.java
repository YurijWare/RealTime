package com.yurijware.bukkit.RealTime;

import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.World;

/**
 * RealTime for Bukkit
 * Class for the time thread
 * 
 * @author Yurij
 */
public class RTTimeThread implements Runnable {
	@SuppressWarnings("unused")
	private final Logger log = Logger.getLogger("Minecraft");
	private List<World> worlds = null;
	
	private Calendar cal;
	
	public RTTimeThread(List<World> worlds) {
		this.worlds = worlds;
	}
	
	@Override
	public void run() {
		cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		long time = (hour*1000-8000+24000)%24000;
		for(World w : worlds){
			w.setTime(time);
		}
	}
	
}
