package com.player.beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;
import com.player.beans.dbload.api.genius.GeniusApiJSONRWService;
import com.player.beans.dbload.spotifyapi.*;
import com.player.model.AASContainer;
import com.player.service.AlbumService;
import com.player.service.ArtistService;
import com.player.service.SongService;

import jdk.internal.org.jline.utils.Log;
enum LoaderService 
{
	
	LOAD_AUDIO_FROM_FILES("lf")  , LOAD_DB_TEST_DATA("ltd"), 
    GENIUS("g"), SPOTIFY_API("s");
	
	private IAASService service;	
	@Autowired
	ArtistService artistService;
	@Autowired
	AlbumService albumService;
	@Autowired
	SongService songService;
	LoaderService(String s) 
	{
		try
		{
			switch(s)
			{
				case "lf":
					service = new FileLoader();
				case "ltd":
					service = new TestSampleAASBasicLoader();
				case "g":
					service = new  GeniusApiJSONRWService();
				case "s":
					service = new SpotifyAPIJSONRWService();
			}
		}
		catch(Exception e) {}

	}
	public IAASService getService()
	{
		return service;
	}
}
enum ServiceConfigType
{
	TEST_DATA(List.of(LoaderService.LOAD_DB_TEST_DATA)),
	TEST_FILE_AND_DATA(List.of(LoaderService.LOAD_DB_TEST_DATA, LoaderService.LOAD_AUDIO_FROM_FILES)),
	PRODUCTION(List.of(LoaderService.LOAD_AUDIO_FROM_FILES));
	
	private List<LoaderService > serviceType;
	 ServiceConfigType(List<LoaderService> serviceType)
	{
		this.serviceType = serviceType;
	}
	public List<LoaderService> getAllServiceTypes() {
		return serviceType;
	}
	 
}

@Component
public class DBAASControlService implements CommandLineRunner/*,UserIOAPI */ {
	Logger log = LogManager.getLogger(GeniusApiJSONRWService.class);
	ServiceConfigType config = ServiceConfigType.TEST_FILE_AND_DATA;
	@Override
	public void run(String... args) throws Exception {
		Thread t = new Thread() {
		    public void run() {
		    	try {
					startDBServices(config);
				} catch (Exception e) {
					e.printStackTrace();
				}				
		    }
		};
		t.start();
	}
	
	public void startDBServices(ServiceConfigType st) throws Exception	
	{	
		switch(st)
		{
			 case TEST_DATA:
				 log.info("Test data is being loaded");
				 executeTestServiceType();
				 break;
			 case TEST_FILE_AND_DATA:
				 log.info("test files is being loaded");
				 executeLocalFileLoaderServiceType();
				 break;
			 case PRODUCTION:
				 executeLocalFileLoaderServiceType();
				 break;
		 	 default:
				 break;
		}


//		List<AASServiceType> choiceList = parseInput(serviceType);
//		List<AASServiceType> choiceList = st.getAllServiceTypes();
//		List<IAASService> serviceList = new ArrayList<>(choiceList.size());
//	
//		for(AASServiceType serviceType: choiceList)
//		{
//			executeTestServiceType(serviceList);
//			serviceList.add(serviceType.getService());	
//		}
//		
	
	
	}	
	private Optional<AASContainer> checkIfAASExistInDB()
	{
		return null;
	}
	private void executeLocalFileLoaderServiceType() throws Exception {
		FileLoader f = new FileLoader();
		Optional<AASContainer> aas = checkIfAASExistInDB();
		f.execute();
//		boolean running = true;
//		int i = 0;
//		while(running)
//		{
//
//			if(serviceList.get(i).getClass() == LoaderServices.LOAD_AUDIO_FROM_FILES.getService().getClass())
//			{
//				FileLoader f = (FileLoader) serviceList.get(i);
//				
//				if(f.getFilesToProcess() > 0)
//				{
//					serviceList.get(i).execute();
//				}
//				else
//				{
//					running = false;
//				}					
//			}							
//			i = (i + 1) % serviceList.size();				
//		}
		DbAASQueue.saveAllAASToRepo();
	}

	private void executeTestServiceType() throws Exception {
		log.info("Now executing test service inside of control");
		for(LoaderService service: ServiceConfigType.TEST_DATA.getAllServiceTypes())
		{
			log.info("check if test is loaded: ");
			TestSampleAASBasicLoader t = new TestSampleAASBasicLoader();
			t.execute();
//			service.getService().execute();
		}
		DbAASQueue.saveAllAASToRepo();
	}

//	private List<AASServiceType> parseInput(String serviceType)
//	{
//		List<AASServiceType> choiceList = List.of(AASServiceType.values());
//		
//		if(!(input.contentEquals("")))
//		{
//			String[] userInputArr = input.split(",");
//
//			for(int i = 0; i < userInputArr.length;i++)
//			{
//				choiceList.remove(userInputArr[i]);
//			}
//		}
//		
//		return choiceList;
//	}

	
}
