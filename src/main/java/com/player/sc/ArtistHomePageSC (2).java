package com.player.sc;

import java.util.Optional;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.player.exception.ArtistException;
import com.player.model.AlbumSP;
import com.player.model.ArtistSP;
import com.player.model.beanless.DataId;
import com.player.model.cpw.ArtistHomePage;
import com.player.model.elw.AllAlbumsELW;
import com.player.model.elw.TopSongsELW;
import com.player.service.AlbumService;
import com.player.service.ArtistService;
import com.player.service.SongService;
@Component
public class ArtistHomePageSC {
	private Logger logger = LogManager.getLogger(ArtistHomePageSC.class);
	@Autowired
	ArtistService artistService;
	@Autowired
	SongService songService;
	@Autowired
	AlbumService albumService;
	public Optional<ArtistSP> getArtist(DataId id)
	{
		return artistService.getArtistContent(id);
	}
	public Optional<TopSongsELW> getTopSongs(AllAlbumsELW albumELW)
	{
		return songService.getTopSongs(albumELW);
	}
	public Optional<AllAlbumsELW> getAllAlbums(DataId id)
	{
		return albumService.getAllAlbumsFromArtistId(id);
	}
	public Optional<ArtistHomePage> getContent(DataId id)
	{
		ArtistSP artist = getArtist(id).get();
		AllAlbumsELW albumsELW = getAllAlbums(id).get();
		TopSongsELW songsELW = getTopSongs(albumsELW).get();
		
		return Optional.ofNullable(new ArtistHomePage(songsELW, albumsELW, artist));			
	}
}
