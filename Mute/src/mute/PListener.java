package mute;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerListener;

public class PListener extends PlayerListener {
	FileConfiguration config = Mute.plugin.getConfig();
	public void onPlayerChat(PlayerChatEvent e) {
		if (config.getBoolean("Players." + e.getPlayer().getName() + ".muted")) {
			e.setCancelled(true);
		}
	}
}
