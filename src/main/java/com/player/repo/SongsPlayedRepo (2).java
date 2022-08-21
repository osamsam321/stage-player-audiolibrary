package com.player.repo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.player.model.ArtistSP;
import com.player.model.SongSP;
import com.player.model.elw.SongsPlayed;

public interface SongsPlayedRepo  extends JpaRepository<SongsPlayed, Long>  {
	@Query(value="SELECT * FROM artistsp WHERE artist_name = :artistName", nativeQuery = true)
	Optional<ArtistSP> existByArtistName(String artistName );

	List<SongsPlayed> findByuserid(long userID);
	

	
	@Query(value="Select * from songsplayed where userid = ?1", nativeQuery = true)
	List<SongsPlayed> findByUserID(long userid);
}
