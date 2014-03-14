package com.caved_in.commons.command;

import com.caved_in.commons.Messages;
import com.caved_in.commons.player.Players;
import org.bukkit.entity.Player;

/**
 * Created By: TheGamersCave (Brandon)
 * Date: 30/01/14
 * Time: 6:50 PM
 */
public class TunnelsXPCommand {

	@CommandController.CommandHandler(name = "xp", usage = "/xp")
	public void playerXPCommand(Player player, String[] args) {
		Players.sendMessage(player, Messages.TUNNELS_XP_BALANCE(player));
	}
}