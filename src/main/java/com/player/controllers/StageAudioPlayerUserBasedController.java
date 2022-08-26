package com.player.controllers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.player.model.AASSingleFieldContainer;
import com.player.model.TopSongs;
import com.player.model.elw.SongsPlayed;
import com.player.service.ArtistService;
import com.player.service.CommonServiceSp;
import com.player.service.SongsPlayedService;
import java.nio.file.Files;

@RestController
@RequestMapping("user/")
public class StageAudioPlayerUserBasedController {
	Logger log = LogManager.getLogger(StageAudioPlayerUserBasedController.class);
	@Autowired
	SongsPlayedService spService;
	@Autowired
	CommonServiceSp commanServiceSp;
	@GetMapping("/getsongsplayed/{userid}")
	public Optional<List<SongsPlayed>> getAllSongsPlayed(@PathVariable("userid")Long userid)
	{
		return spService.getSongsPlayedByUserId(userid);
	}
	@PostMapping("/newsongplayed")
	public void newSongPlayed( @RequestBody SongsPlayed songsplayed )
	{
		log.info("newsongplayed info: " + songsplayed.toString());
		spService.saveSongsPlayed(songsplayed);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getTopSongs/{amount}")
	public ResponseEntity<List<TopSongs>> getTopTenSongs(@PathVariable("amount") int amount)
	{
		return ResponseEntity.of(commanServiceSp.findTopSongsUsingAASSingleFieldContainer(amount));
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/album_cover/{id}")
	public @ResponseBody byte[] getImage(@PathVariable("id") String id) throws IOException {
			String fileType = ".jpg";
		    Resource resource = new ClassPathResource("static/album_covers");
			File file = new File(resource.getFile().getAbsolutePath() + "/" + id + fileType);
			
		    log.info("image path being grabbed: " + file.getAbsolutePath() + fileType );

			return Files.readAllBytes(file.toPath());
		
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/getAudioMP3/{songid}")
	public @ResponseBody byte[] getAudio(@PathVariable("songid") String songid) throws IOException {
			String fileType = ".mp3";
		    Resource resource = new ClassPathResource("static/audio_play");
			File file = new File(resource.getFile().getAbsolutePath() + "/" + songid + fileType);
			
		    log.info("image path being grabbed: " + file.getAbsolutePath() + fileType );

			return Files.readAllBytes(file.toPath());
		
	}

}
