package com.player.profile.PlayerController;

import java.util.List;

import com.player.profile.PlayerBean.Players;



public interface PlayerControllerInterface {
	public List<Players> getAllPlayers();

	public Players getPlayer(int id);

	public void save(Players player);

	public void deleteById(int id);
}
