package com.player.profile.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.player.profile.PlayerBean.Players;



public interface PlayerServiceInterface {
	public List<Players> getAllPlayers();

	public Players getPlayer(int Id);

	public void deleteById(int id);

	public Players addPlayer(Players player);

	Page<Players> findPage(int page, int size);

	
}
