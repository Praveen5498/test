package com.player.profile.PlayerRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.player.profile.PlayerBean.Players;

public interface PlayerRepository extends JpaRepository<Players, Integer> {

}
