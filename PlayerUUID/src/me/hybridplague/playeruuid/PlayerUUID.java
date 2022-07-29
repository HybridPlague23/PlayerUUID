package me.hybridplague.playeruuid;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class PlayerUUID extends JavaPlugin {

	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		super.onDisable();
	}
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("uuid")) {
			if (args.length == 0) {
				sender.sendMessage("/uuid <player>");
				return true;
			} else {
				if (Bukkit.getOfflinePlayer(args[0]).hasPlayedBefore() || Bukkit.getOfflinePlayer(args[0]).isOnline()) {
					TextComponent message = new TextComponent(ChatColor.GRAY + Bukkit.getOfflinePlayer(args[0]).getName() + "'s UUID: " + ChatColor.WHITE + Bukkit.getOfflinePlayer(args[0]).getUniqueId());
					message.setClickEvent(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, Bukkit.getOfflinePlayer(args[0]).getUniqueId().toString()));
					message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.GRAY + "Click to copy the UUID to your clipboard!").create()));
					sender.spigot().sendMessage(message);
					//sender.sendMessage(ChatColor.GRAY + Bukkit.getOfflinePlayer(args[0]).getName() + "'s UUID: " + ChatColor.WHITE + Bukkit.getOfflinePlayer(args[0]).getUniqueId());
					return true;
				} else {
					sender.sendMessage("Player not found.");
				}
			}
		}
		
		return true;
	}
	
}
