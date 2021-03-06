package com.fuzzoland.CommandSyncServer;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerConnectedEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.util.concurrent.TimeUnit;

public class EventListener implements Listener {

	private CSS plugin;

	public EventListener(CSS plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onServerConnected(ServerConnectedEvent event) {
		ProxiedPlayer player = event.getPlayer();
		if(plugin.pq.containsKey(player.getName())) {
			this.plugin.getProxy().getScheduler().schedule(this.plugin, new CommandThread(plugin, player), 0, 100, TimeUnit.MILLISECONDS);
		}
	}
}
