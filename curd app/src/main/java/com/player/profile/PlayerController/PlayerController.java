package com.player.profile.PlayerController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.player.profile.PlayerBean.Players;
import com.player.profile.Service.PlayerService;
import com.player.profile.Service.PlayerServiceInterface;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("cricket/api")

public class PlayerController  {

	private PlayerServiceInterface playerService;
	@Autowired
	public PlayerController(PlayerService ps) {
		this.playerService=ps;
	}
	 @CrossOrigin(origins = "*")
	 @GetMapping("/players/view/{page}/{size}")
	    public Page<Players> findPaginated(@PathVariable int page, @PathVariable int size) {
	 
	        Page<Players> resultPage = playerService.findPage(page, size);
	        if (page > resultPage.getTotalPages()) {
	            throw new RuntimeException("Page is no results choose lesser page number");
	        }
	       // resultPage.getTotalElements()
	        return resultPage;
	    }
	 @CrossOrigin(origins = "*")
	@GetMapping("/players")
	public List<Players> getAllPlayers() {
		// TODO Auto-generated method stub
		
		return playerService.getAllPlayers();
	}
	 @CrossOrigin(origins = "*")
	@GetMapping("/players/{id}")	
	public Players getPlayer(@PathVariable int id) {
		// TODO Auto-generated method stub
		Players player = playerService.getPlayer(id);

		if (player == null) {
			throw new RuntimeException("Employee id not found - " + id);
		}
		return player;
	}
	 @CrossOrigin(origins = "*")
	@PostMapping("/players")
	public Players addPlayer(@RequestBody Players player) {
		// TODO Auto-generated method stub
		player.setId(0);

		playerService.addPlayer(player);

		return player;
	}
	 @CrossOrigin(origins = "*")
	@PutMapping("/players")
	public Players updatePlayer(@RequestBody Players player) {
		
		playerService.addPlayer(player);
		
		return player;
	}
	 @CrossOrigin(origins = "*")
	@DeleteMapping("/players/{id}")
	public void deletePlayer(@PathVariable int id) {
		// TODO Auto-generated method stub
		Players player = playerService.getPlayer(id);

		// throw exception if null

		if (player == null) {
			throw new RuntimeException("Employee id not found - " + id);
		}

		playerService.deleteById(id);

		// return player;

	}

   

}
