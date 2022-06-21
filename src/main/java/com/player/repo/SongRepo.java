package com.player.repo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.player.model.AlbumSP;
import com.player.model.SongSP;
import com.player.model.beanless.DataId;
import com.player.model.elw.TopSongsELW;



public interface SongRepo extends JpaRepository<SongSP, UUID>  {
	@Query(value = "SELECT * FROM song WHERE album_id = :id ORDER BY views ASC", nativeQuery = true )
	public List<SongSP> getTopSongsFromAlbumID(UUID id);
	
	@Query(value="SELECT * FROM songsp WHERE song_name = :string", nativeQuery = true)
	public SongSP getSongFromName(String string);

	
	@Query(value="SELECT * FROM songsp WHERE song_name = :songName", nativeQuery = true)
	Optional<SongSP> existBySongName(String songName );

}
