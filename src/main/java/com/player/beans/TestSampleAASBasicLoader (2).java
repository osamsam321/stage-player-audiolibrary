package com.player.beans;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.player.beans.dbload.api.genius.GeniusApiJSONRWService;
import com.player.controllers.StageAudioPlayerController;
import com.player.model.AASContainer;
import com.player.model.AlbumSP;
import com.player.model.ArtistSP;
import com.player.model.SongSP;
import com.player.repo.AlbumRepo;
import com.player.repo.ArtistRepo;
import com.player.repo.SongRepo;

import jdk.internal.org.jline.utils.Log;

@Component
public class TestSampleAASBasicLoader implements IAASTest {
	Logger log = LogManager.getLogger(TestSampleAASBasicLoader.class);
	
	public TestSampleAASBasicLoader()
	{
		
	}

	public void AddAAS()
	{
		ArtistSP artist1 = new ArtistSP("Ratt", LocalDateTime.now(), "C:/Users/osams/Music/m1/Ratt - Lay It Down .mp3", "rock", 1L);
		AlbumSP album1 = new AlbumSP("Invasion Of Your Privacy", LocalDateTime.now(), "C:/Users/osams/OneDrive/Pictures/projects/stage-player/Ratt_1.jpg"
				, artist1);
		SongSP song1 = new SongSP("Lay it down", "C:/Users/osams/Music/m1/Ratt - Lay It Down .mp3",
				255f, 1L, List.of(album1));
		AASContainer aas = new AASContainer();
		aas.setArtist(artist1);
		aas.setAlbums(List.of(album1));
		aas.setSongs(List.of(song1));
		DbAASQueue.add(aas);
//		AASContainer aas = new AASContainer(artist1);
//				aas.getArtist().getAlbums().add(album1);
//				aas.getArtist().getAlbums().get(0).getSongs().add(song1);
//			DbAASQueue.saveArtist(artist1);
//			DbAASQueue.saveAlbum(album1);
//			DbAASQueue.saveSong(song1);
//		log.info("aas info: " + aas.getArtist().toString() 
//				+ "\n" + aas.getArtist().getAlbums().get(0).toString()
//				+ "\n" +  aas.getArtist().getAlbums().get(0) 
//				.getSongs().toString());
//				log.info("artist data: " + aas.getArtist());
//		DbAASQueue.add(aas);
		
	}


	@Override
	public boolean execute() {
		log.info("inside of test execute method");
		AddAAS();	
		return true;
	}


	@Override
	public void start() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
