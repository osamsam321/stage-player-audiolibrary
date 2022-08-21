package com.player.controllers;

import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import com.player.model.AlbumSP;
import com.player.model.ArtistSP;
import com.player.model.SongSP;
import com.player.model.beanless.DataId;
import com.player.model.cpw.ArtistHomePage;
import com.player.sc.ArtistHomePageSC;
import com.player.service.AlbumService;
import com.player.service.ArtistService;
import com.player.service.SongService;


@RestController
public class StageAudioPlayerController {
	@Autowired
	SongService ss;
	@Autowired
	ArtistHomePageSC as;
	@Autowired
	ArtistService artistService;
	@Autowired
	AlbumService albumService;
	@GetMapping("/audioplayer/artist/{id}")
	public ResponseEntity<ArtistHomePage> getArtistHomePage(@PathVariable("id") DataId id)
	{	
		return ResponseEntity.of(as.getContent(id));
	}
	//------test----------
	@PostMapping("/audioplayer/new/artist")	
	public ResponseEntity<ArtistSP> pushArtist(@ModelAttribute("artist") ArtistSP artist)
	{	
		return ResponseEntity.of(artistService.saveArtist(artist));
	}	
	@GetMapping("/info/artist/{id}")
	public ResponseEntity<ArtistSP> getArtist(@PathVariable("id") DataId id)
	{	
		return ResponseEntity.of(artistService.getArtistContent(id));
	}
	@GetMapping("/info/artist/")
	public ResponseEntity<List<ArtistSP>> getArtist()
	{	
		return ResponseEntity.of(artistService.getAllArtist());
	}
	@PostMapping("/audioplayer/new/song")	
	public ResponseEntity<SongSP> pushSong(@ModelAttribute("song") SongSP song)
	{	
		return ResponseEntity.of(ss.saveSong(song));
	}	
	@GetMapping("/audioplayer/song/{id}")
	public ResponseEntity<SongSP> getSong(@PathVariable("id") DataId id)
	{	
		return ResponseEntity.of(ss.getSong(id));
	}
	@GetMapping("/audioplayer/song/")
	public ResponseEntity<List<SongSP>> getAllSongs()
	{	
		return ResponseEntity.of(ss.getAllSongs());
	}
	@PostMapping("/audioplayer/new/album")	
	public ResponseEntity<AlbumSP> pushAlbum(@ModelAttribute("album") AlbumSP album)
	{	
		return ResponseEntity.of(albumService.saveAlbum(album));
	}	
	@GetMapping("/audioplayer/album/")
	public ResponseEntity<List<AlbumSP>> getAllAlbums()
	{	
		return ResponseEntity.of(albumService.getAllAlbums());
	}
	
	
}
