package com.player.beans.dbload.api.genius;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


import com.mpatric.mp3agic.*;
import com.player.beans.DbAASQueue;
import com.player.beans.IAASGeniusService;
import com.player.beans.IAASService;
import com.player.beans.IDbAASExternalData;
import com.player.model.AASContainer;
import com.player.model.SongSP;

import core.GLA;
import genius.SongSearch;
import jdk.internal.org.jline.utils.Log;

@Component
public class GeniusApiJSONRWService implements IAASService {
	Logger log = LogManager.getLogger(GeniusApiJSONRWService.class);
	
	
	public void updateAASDataByGeniusData() {
		try
		{
//			this.albumName = null;
//			this.year = -1;
//			this.imgPath = null;
//			this.artist = null;
//			this.songs = null;
//			AASContainer aas = DbAASQueue.peek();
//			SongSearch search = new GLA().search(aas.getSong().getSongName());
//			
//			aas.getArtist().newFilledArtist(new com.player.model.ArtistSP(search.getHits().getFirst().getArtist().getName(),
//					Integer.valueOf(aas.getArtist().getStartYear()), search.getHits().getFirst().getArtist().getImageUrl(),
//					aas.getArtist().getGenre(),Long.valueOf( aas.getArtist().getTotalViews())));
//			
//			aas.getAlbum().newFilledAlbum(new com.player.model.AlbumSP(null, -1, null, aas.getArtist(), null));
			
			
			
		}
		catch(Exception e)
		{
			log.error("Genius url not found");
		}

		
		//------------   test 
//		List<SongSearchResult> searchResults = client.performSongSearch("Hey You");
//		Song song = client.getSong(searchResults.get(0));
//		System.out.println(song.songLyrics()); // Prints the Lyrics
//		System.out.println(song.songName());
//		log.info("song info: " + song.artistName());
		
	}
//    @Override
//	public void execute() throws SongNotFoundException
//	{
//
//		
//		
//		
//		
//				String buffer = "";
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Authorization", "Bearer " + authToken);
//
//
//		HttpEntity<?> httpEntity = new HttpEntity<>(headers);
//		id = 11110;
//		while(id < dataSize)
//		{
//			id++;
//			try
//			{
//				Optional <HttpEntity<String>> response = Optional.ofNullable(
//						restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class, id));
//						
//						
//				if(response.isPresent())
//				{
//					log.info("Request succesful");
//					JSONResult += response.get().getBody();
//				}
//			}
//			catch(Exception e) 
//			{
//				log.warn("nothing found in genius request");
//			}
//						
//		}
//		log.info("finished data get request");
//	}


	

	@Override
	public void start() throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean execute() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}


	

	
	


}
