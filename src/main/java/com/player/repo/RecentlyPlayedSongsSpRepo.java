package com.player.repo;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.player.model.RecentlyPlayedSongsSp;

public interface RecentlyPlayedSongsSpRepo extends JpaRepository<RecentlyPlayedSongsSp, Long>  {
	

	public Optional<RecentlyPlayedSongsSp> findByUserId(Long UserId);
}
