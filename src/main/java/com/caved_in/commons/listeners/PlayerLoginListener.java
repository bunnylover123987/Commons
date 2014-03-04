package com.caved_in.commons.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import com.caved_in.commons.Commons;
import com.caved_in.commons.config.TunnelsPermissions;

public class PlayerLoginListener implements Listener {
	
	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent event) {
		if (Commons.getConfiguration().getMaintenanceConfig().isMaintenanceMode()) {
			if (!event.getPlayer().hasPermission(TunnelsPermissions.MAINTENANCE_WHITELIST)) {
				event.setKickMessage(Commons.getConfiguration().getMaintenanceConfig().getKickMessage());
				event.setResult(PlayerLoginEvent.Result.KICK_OTHER);
			}
		}
		
		if (Commons.getConfiguration().getPremiumConfig().isPremiumMode()) {
			if (!Commons.playerDatabase.getPlayerWrapper(event.getPlayer().getName()).isPremium()) {
					event.setKickMessage(Commons.getConfiguration().getPremiumConfig().getKickMessage());
					event.setResult(PlayerLoginEvent.Result.KICK_OTHER);
			}
		}
	}
}