package com.player.controllers;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.player.jsondbcm.dao.Test;
import com.player.model.AlbumSP;
import com.player.model.ArtistSP;
import com.player.model.JSONDBCM;
import com.player.model.SongSP;
import com.player.model.beanless.DataId;
import com.player.model.cpw.ArtistHomePage;
import com.player.sc.ArtistHomePageSC;
import com.player.service.AlbumService;
import com.player.service.ArtistService;
import com.player.service.MBBaseJC;
import com.player.service.MBBaseJC.MBBaseQueryAndJSONBuilder;
import com.player.service.MBQueryBuilder;
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
	@Autowired
	MBQueryBuilder mbq;
	@Autowired
	Test test;
	@Autowired
	MBBaseJC mbBaseJC;
	@Autowired
	MBBaseQueryAndJSONBuilder mbBuilder;
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
	
	
	
	
	

	
	//using new musicbrainz architecture
	
	@GetMapping("/content/artist/{id}")
	public ResponseEntity<List<Map<String, Object>>> getArtistSPContent(@PathVariable("id") Long id)
	{	
//		return ResponseEntity.ok(new MBBaseJC.
//				MBBaseQueryAndJSONBuilder().getAllArtistWithId(id).getJsonDBCM().getJSONDBResult());
		return  ResponseEntity.ok(mbBaseJC.buildDBCM(mbBuilder.newJSONDBCM().getAllArtistWithId(id)
									.build()).getJsonDBCM().getJSONDBResult());
//		test.test();
//		return null;
	}
	@GetMapping("/content/track/{id}")
	public ResponseEntity<List<Map<String, Object>>> getTrackSpContent(@PathVariable("id") Long id)
	{	
//		return ResponseEntity.ok(new MBBaseJC.
//				MBBaseQueryAndJSONBuilder().getAllArtistWithId(id).getJsonDBCM().getJSONDBResult());
		return  ResponseEntity.ok(mbBaseJC.buildDBCM(mbBuilder.newJSONDBCM().getTrackWithId(id)
									.build()).getJsonDBCM().getJSONDBResult());
//		test.test();
//		return null;
	}
	@GetMapping("/content/release/{id}")
	public ResponseEntity<List<Map<String, Object>>> getReleaseSpContent(@PathVariable("id") Long id)
	{	
//		return ResponseEntity.ok(new MBBaseJC.
//				MBBaseQueryAndJSONBuilder().getAllArtistWithId(id).getJsonDBCM().getJSONDBResult());
		return  ResponseEntity.ok(mbBaseJC.buildDBCM(mbBuilder.newJSONDBCM().getReleaseWithId(id)
									.build()).getJsonDBCM().getJSONDBResult());
//		test.test();
//		return null;
	}
	 

	@GetMapping("/playback/thirdparty/mp3/track/{id}")
	public ResponseEntity<List<Map<String, Object>>> playMp3Track(@PathVariable("id") Long id)
	{	
		MBDSL("");
		return null;
	}
	/**** @param String JSON body representing the values the client needs from the database
	 * @return the values from  database requested from the JSON body
	 * 
	 * 
	 * */
	@GetMapping("/content/JSONSelectionBuilder/")
	public ResponseEntity<List<Map<String, Object>>> MBDSL(@RequestBody String selection)
	{	
		return null;
		
	}
	
	
}
