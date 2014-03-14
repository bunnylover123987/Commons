package com.caved_in.commons.command;

import com.caved_in.commons.Messages;
import com.caved_in.commons.player.Players;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;

/**
 * Created By: TheGamersCave (Brandon)
 * Date: 30/01/14
 * Time: 7:07 PM
 */
public class TeleportHereCommand {
	@CommandController.CommandHandler(name = "tphere", permission = "tunnels.common.tphere", aliases = {"bring"})
	public void onTeleportHereCommand(Player player, String[] args) {
		if (args.length > 0) {
			String playerName = args[0];
			if (Players.isOnline(playerName)) {
				Player playerToTeleport = Players.getPlayer(playerName);
				playerToTeleport.teleport(player, PlayerTeleportEvent.TeleportCause.COMMAND);
			} else {
				Players.sendMessage(player, Messages.PLAYER_OFFLINE(playerName));
			}
		} else {
			Players.sendMessage(player, Messages.INVALID_COMMAND_USAGE("name"));
		}
	}
}