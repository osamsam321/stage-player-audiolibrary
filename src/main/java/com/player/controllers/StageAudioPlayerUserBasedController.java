package com.player.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.player.model.AASSingleFieldContainer;
import com.player.model.TopSongs;
import com.player.model.elw.SongsPlayed;
import com.player.service.ArtistService;
import com.player.service.CommonServiceSp;
import com.player.service.SongsPlayedService;

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
	@GetMapping("/getTopSongs/{amount}")
	public ResponseEntity<List<TopSongs>> getTopTenSongs(@PathVariable("amount") int amount)
	{
		return ResponseEntity.of(commanServiceSp.findTopSongsUsingAASSingleFieldContainer(amount));
	}


}
