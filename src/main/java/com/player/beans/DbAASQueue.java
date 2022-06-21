package com.player.beans;

import java.util.LinkedList;
import java.util.Queue;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.player.beans.dbload.api.genius.GeniusApiJSONRWService;
import com.player.model.AASContainer;
import com.player.model.AlbumSP;
import com.player.model.ArtistSP;
import com.player.model.SongSP;
import com.player.repo.AlbumRepo;
import com.player.repo.ArtistRepo;
import com.player.repo.SongRepo;
import com.player.service.AASContainerService;
import com.player.service.AlbumService;
import com.player.service.ArtistService;
import com.player.service.SongService;
import com.player.sql.AASMapper;
@Component
public class DbAASQueue {
	static Logger log = LogManager.getLogger(DbAASQueue.class);
//    @Autowired
//    private ArtistService artistServiceLocal;
//    private static ArtistService artistService; 
//    @Autowired
//    private AlbumService albumServiceLocal;
//    private static AlbumService albumService;
//    @Autowired
//    private  SongService songServiceLocal;
//    private static SongService songService;
   
    @Autowired
    private static AASContainerService aasContainerService;
    
    @Autowired
    private AASContainerService aasContainerServiceLocal;
    
   
	private static Queue<AASContainer> queue  = new LinkedList<>();;
	private static DbAASQueue instance = null;

	@PostConstruct
	public void init() {
		DbAASQueue.aasContainerService = aasContainerServiceLocal;
	}
	public static void add(AASContainer a)
	{
		queue.add(a);
	}
	public static AASContainer peek()
	{
		return queue.peek();
	}
	public static AASContainer peekOrGetNew()
	{
		AASContainer aas = queue.peek();		
		return (aas != null)? aas: new AASContainer();
	}
	public static void delete()
	{
		queue.remove();
	}
	@Bean
	public static void saveAllAASToRepo() throws Exception {
		while(!queue.isEmpty())
		{
			AASContainer aas = queue.poll();
			
			if(aas != null)
			{
				// old test way
//				AASMapper mapper = new AASMapper();
//				log.info("queue artist test: " + aas.getArtist());
//				
//				
//				artistService.saveArtist(aas.getArtist());
//				albumService.saveAllAlbums(aas.getAlbums());
//				songService.saveAllSongs(aas.getSongs());
				
				//new way check db
				
				aasContainerService.saveAAS(aas);
			
			}			
		}
	
	}

	
	
}
