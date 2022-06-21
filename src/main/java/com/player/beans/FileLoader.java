package com.player.beans;

import java.io.File;
import java.io.FilenameFilter;
import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.player.beans.dbload.api.genius.GeniusApiJSONRWService;
import com.player.model.AASContainer;
import com.player.repo.AlbumRepo;
import com.player.repo.ArtistRepo;
import com.player.repo.SongRepo;
import com.player.service.AlbumService;
import com.player.service.ArtistService;
import com.player.service.SongService;


public class FileLoader implements IAASService {
//	final String audioPaths[] = {"C:\\Users\\osams\\Music\\m1"};
	final String audioPaths[] = {"C:\\audio"};
	Logger log = LogManager.getLogger(FileLoader.class);
	public static FileLoader instance;
	int fIncrement;
	private Long filesToProcess;
	private ID3VService id3Service;
	@Autowired
	ArtistService artistService;
	@Autowired
	AlbumService albumService;
	@Autowired
	SongService songService;
	File file;
	public FileLoader() throws Exception {
		start();
		}
	
	public List<File> getAudioFileMP3byLocal() {
		log.info("Starting file reader process");
		File[] files = file.listFiles();
		List<File> filesToProcess = new LinkedList<>();
		for(File f: files)
		{
			int length = f.getName().length();
			if(length > 4)
			{
				if(f.getName().substring(length - 4, length).equals(".mp3"))
				{
					
					filesToProcess.add(f);
					log.info("files to process: " + f.getAbsolutePath() + "]");
				}
			}
		}
		return filesToProcess;
	}
	public boolean process() throws Exception
	{
			boolean flag = false;
			log.info("inside of more Files to Process method");			
			AASContainer aas = null;
			List <File> filesToProcess = getAudioFileMP3byLocal();
			for(File file: filesToProcess )
			{
				if(id3Service.init(file))
				{
//					if(id3Service.hasId3v2())
//					{
//						id3Service.id3v2 = id3Service.mp3.getId3v2Tag();
//					}
//					
					if(id3Service.hasId3v1())
					{
						id3Service.id3v1 = id3Service.mp3.getId3v1Tag();
						aas = id3Service.id3v1ContentToAAS();
						flag = true;
					}				
				}
			
			}
			
			
			return flag;
}
	public static synchronized FileLoader getInstance() throws Exception
	{
		if(instance == null)
		{
			instance = new FileLoader();
		}
		
	   return instance;
	}
	public boolean moreFilesToProcess()
	{
		return (totalFiles() - fIncrement) > 0; 
	}
	public long getFilesToProcess() {
		return filesToProcess;
	}

	public void setFilesToProcess(long filesToProcess) {
		this.filesToProcess = filesToProcess;
	}
	public int totalFiles()
	{
		return audioPaths.length;
	}
	
	@Override
	public void start() throws Exception {
		
		id3Service = new ID3VService();
		fIncrement = 0;
		file = new File(audioPaths[0]);
	}

	@Override
	public boolean execute() throws Exception {
		log.info("Inside of process method");
		return process();
	}
	 
}
