package com.player.repo;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.player.model.ArtistSP;

public interface ArtistRepo extends JpaRepository<ArtistSP, Long>  {
	public Optional<ArtistSP> getArtistById(Long id);
	public Optional<ArtistSP> getArtistById(String id);
	@Query(value="SELECT * FROM artistsp WHERE artist_name = :string", nativeQuery = true)
	public ArtistSP getArtistFromName(String string);
	
	@Query(value="SELECT * FROM artistsp WHERE artist_name = :artistName", nativeQuery = true)
	Optional<ArtistSP> existByArtistName(String artistName );
}
