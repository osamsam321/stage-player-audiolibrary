package com.player.repo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.player.model.AlbumSP;
import com.player.model.ArtistSP;

public interface AlbumRepo extends JpaRepository<AlbumSP, UUID>  {
//	@Query(value ="SELECT * FROM album WHERE artist_id = :id", nativeQuery= true)
	@Query(value ="SELECT * FROM album WHERE artist_id = :id", nativeQuery= true)
	public List<AlbumSP> getAllAlbumsFromArtistId(@Param("id") UUID id);
	
	@Query(value="SELECT * FROM albumsp WHERE album_name = :string", nativeQuery = true)
	public AlbumSP getAlbumFromName(String string);
	
	@Query(value="SELECT * FROM albumsp WHERE ALBUM_NAME = :albumName", nativeQuery = true)
	Optional<AlbumSP> existByAlbumName(String albumName);
}
