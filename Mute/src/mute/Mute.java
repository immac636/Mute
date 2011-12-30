package mute;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Event;
import org.bukkit.plugin.java.JavaPlugin;

public class Mute extends JavaPlugin {
	public static Mute plugin;
	@Override
	public void onDisable() {
		System.out.println("[Mute] Disabled!");
	}

	@Override
	public void onEnable() {
		plugin = this;
		System.out.println("[Mute] Enabled!");
		loadEvents();
		loadCommands();
	}

	private void loadCommands() {
		CommandExecutor mute = new Command();
		Mute.plugin.getCommand("mute").setExecutor(mute);
	}

	private void loadEvents() {
		Bukkit.getServer().getPluginManager().registerEvent(Event.Type.PLAYER_CHAT, new PListener(), Event.Priority.Normal, this);
	}
}
