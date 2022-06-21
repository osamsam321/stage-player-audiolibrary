package com.player.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.player.model.AASContainer;
import com.player.model.AlbumSP;
import com.player.model.ArtistSP;
import com.player.model.SongSP;
import com.player.sql.AASMapper;

@Service
@Transactional
public class AASContainerService 
{
	Logger log = LogManager.getLogger(AASContainerService.class);
	    @Autowired
	    private ArtistService artistService; 
	    @Autowired
	    private  AlbumService albumService;
	    @Autowired
	    private  SongService songService;
	
	public void saveAAS(AASContainer aas) throws Exception
	{
		boolean artistFound = false;
		boolean albumFound = false;
		AASMapper mapper = new AASMapper();
		log.info("queue artist test: " + aas.getArtist());
		log.info("artist formating final value: " +  formatAASValue(aas.getArtist().getArtistName()));
		
		if(!(artistService.existsByArtistName(formatAASValue(aas.getArtist().getArtistName()))))
		{
			log.info("artist not found in stage-player-t database");
			artistService.saveArtist(aas.getArtist());
		}
		else
		{
			artistFound = true;
		}
		for(AlbumSP album: aas.getAlbums())
		{
			if(!(albumService.existByAlbumName(formatAASValue(album.getAlbumName()))))
			{	
				if(artistFound)
				{
					ArtistSP artistTemp = artistService.getArtistFromName(aas.getArtist().getArtistName()).get();
					album.setArtist(null);
					album.setArtist(artistTemp);
				}
				log.info("saving album with details: " + album.toString());
				albumService.saveAlbum(album);
			}
			else
			{
				albumFound = true;
			}
				
		}
		
		for(SongSP song: aas.getSongs())
		{
			log.info("song info: " + song.toString());
			// please add code to check for duplicate songs
			if(!(songService.existBySongName(formatAASValue(song.getSongName()))))
			{
				if(artistFound)
				{
					ArtistSP artistTemp = artistService.getArtistFromName(aas.getArtist().getArtistName()).get();
					song.setArtist(null);
					song.setArtist(artistTemp);
				}
				
				for(int i = 0; i < aas.getAlbums().size();i++)
				{
					AlbumSP albumSp = aas.getAlbums().get(i);
					if(albumSp != null && albumService.existByAlbumName(albumSp.getAlbumName()))
					{
						Optional<AlbumSP> albumTemp = albumService.getAlbumFromName(albumSp.getAlbumName());
						if(albumTemp.isPresent())
						{
							ArrayList albumSPTempList = (ArrayList) song.getAlbums();
							albumSPTempList.remove(i);
							albumSPTempList.add(albumTemp.get());
							song.setAlbums(albumSPTempList);
						}
						
					}
					log.info("saving song with details: " + song.toString());
					songService.saveSong(song);
				}
				
			}
				

		}
		
	}
		public  String formatAASValue(String word) throws Exception
		{
			return (word != null && !word.isEmpty())? ((Character.toUpperCase(word.charAt(0)) + "" ) 
						+ word.substring(1).toLowerCase()): "";	
		}
}
