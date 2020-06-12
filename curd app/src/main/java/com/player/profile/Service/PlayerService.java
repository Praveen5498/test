package com.player.profile.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.player.profile.PlayerBean.Players;
import com.player.profile.PlayerRepository.PlayerRepository;
import org.springframework.data.domain.Sort;


@Service
public class PlayerService implements PlayerServiceInterface {

	private PlayerRepository playerRepository;
	@Autowired
	public PlayerService(PlayerRepository pr) {
		this.playerRepository=pr;
	}
	@Override
	@Transactional
	public List<Players> getAllPlayers() {
		// TODO Auto-generated method stub
		
		return playerRepository.findAll();
	}

	@Override
	@Transactional
	public Players getPlayer(int Id) {
		// TODO Auto-generated method stub
		Optional<Players> result = playerRepository.findById(Id);

		Players player = null;

		if (result.isPresent()) {
			player = result.get();
		} else {
			throw new RuntimeException("Did not fint employee id - " + Id);
		}
		return player;
	}

	@Override
	@Transactional
	public Players addPlayer(Players player) {
		// TODO Auto-generated method stub
		playerRepository.save(player);
		return player;
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		playerRepository.deleteById(id);
		
	}
	 @Override
	    public Page<Players> findPage(int page, int size) {
	        return playerRepository.findAll( PageRequest.of(page, size,Sort.by("id")));
	    }

	

}
