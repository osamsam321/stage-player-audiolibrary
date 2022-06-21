package com.player.beans;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v1Tag;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import com.player.model.AASContainer;
import com.player.model.AlbumSP;
import com.player.model.ArtistSP;
import com.player.model.SongSP;


@Component
public class ID3VService{
	 Logger log = LogManager.getLogger(ID3VService.class);
	 ID3v1 id3v1;
	 ID3v2 id3v2;
	 Mp3File mp3;
	 File file;
	 public ID3VService() 
	 {
		 mp3 = null;
		 file = null;
	 }
	 public boolean init(File file)
	 {
		 boolean flag = true;
		 boolean adequateData = true;
		 try
		 {
			  mp3 = new Mp3File(file);
		 }
		 catch(Exception e)
		 {
			log.error(e);
			flag = false;
		 }	
		 this.file = file;
		 adequateData = hasAdequateData();
		 log.info("mp3 file has adequate data" + adequateData);
		 return flag && hasAdequateData();
		 
	 }
	 public boolean hasAdequateData()
	 {
		 return hasId3v1() || hasId3v2();
	 }
	 public boolean hasId3v1()
	 {
		 return mp3 != null && mp3.hasId3v1Tag();
	 }
	 public boolean hasId3v2()
	 {
		 return mp3 != null && mp3.hasId3v2Tag();
	 }
	public void getId3v1(File file) throws Exception
	{
		if(init(file));
		{
			
		}
	}
	
//	@Override
//	public void updateAASDataByMetaData() throws Exception {
//		
//
//		AASContainer aas = DbAASQueue.peek();
//		if(aas != null)
//		{
//			
//			File file = new File(aas.get);
//			
//			if(file.exists() && file != null)
//			{
//				aas = updateWithID3V1Tag( file);
//			}
//		}
//	
//			
//		DbAASQueue.add(aas);
//		////to get album image
////		Mp3File mp3file = new Mp3File("SomeMp3File.mp3");
////		if (mp3file.hasId3v2Tag()) {
////		  ID3v2 id3v2Tag = mp3file.getId3v2Tag();
////		  byte[] imageData = id3v2Tag.getAlbumImage();
////		  if (imageData != null) {
////		    String mimeType = id3v2Tag.getAlbumImageMimeType();
////		    // Write image to file - can determine appropriate file extension from the mime type
////		    RandomAccessFile file = new RandomAccessFile("album-artwork", "rw");
////		    file.write(imageData);
////		    file.close();
////		  }
////		}
//		
////		Mp3File mp3file = new Mp3File("SomeMp3File.mp3");
////		ID3v2 id3v2Tag;
////		if (mp3file.hasId3v2Tag()) {
////		  id3v2Tag = mp3file.getId3v2Tag();
////		} else {
////		  // mp3 does not have an ID3v2 tag, let's create one..
////		  id3v2Tag = new ID3v24Tag();
////		  mp3file.setId3v2Tag(id3v2Tag);
////		}
////		id3v2Tag.setTrack("5");
////		id3v2Tag.setArtist("An Artist");
////		id3v2Tag.setTitle("The Title");
////		id3v2Tag.setAlbum("The Album");
////		id3v2Tag.setYear("2001");
////		id3v2Tag.setGenre(12);
////		id3v2Tag.setComment("Some comment");
////		id3v2Tag.setLyrics("Some lyrics");
////		id3v2Tag.setComposer("The Composer");
////		id3v2Tag.setPublisher("A Publisher");
////		id3v2Tag.setOriginalArtist("Another Artist");
////		id3v2Tag.setAlbumArtist("An Artist");
////		id3v2Tag.setCopyright("Copyright");
////		id3v2Tag.setUrl("http://foobar");
////		id3v2Tag.setEncoder("The Encoder");
////		mp3file.save("MyMp3File.mp3");
////	}
//	}


	public AASContainer id3v1ContentToAAS() throws UnsupportedTagException, InvalidDataException, IOException {
//		artistName = "";
//		startYear = 0;
//		imgPath = "";
//		genre = "";
//		totalViews = 0;
		
//		this.albumName = null;
//		this.year = -1;
//		this.imgPath = null;
//		this.artist = null;
//		this.songs = null;
		
//		this.songName = songName;
//		this.date = date;
//		this.path = path;
//		this.seconds = seconds;
//		this.genre = genre;
//		this.views = views;
//		this.album = album;
		
		Mp3File mp3File = mp3;
		ID3v1 id3;
//		if (mp3file.hasId3v1Tag()) {
		  id3 =  mp3File.getId3v1Tag();
		  ArtistSP ar = new ArtistSP(id3.getArtist(), LocalDateTime.now(), null, id3.getGenreDescription(), -1L);
		  AlbumSP al = new AlbumSP(id3.getAlbum(), LocalDateTime.now(), null, ar);
		  SongSP s = new SongSP(id3.getTitle(), file.getAbsolutePath(), Long.valueOf(mp3.getLengthInSeconds()).floatValue(), 
				 Long.valueOf(1),  new ArrayList(List.of(al)));
		  s.setArtist(ar);
		  ar.setAlbums(null);
		 AASContainer aas = new AASContainer(ar, List.of(al), new ArrayList(List.of(s)));
		  log.info("artist metadata: " +  aas.getArtist());
		  log.info("album metadata: " + aas.getAlbums());
		  DbAASQueue.add(aas);
//		} 
		return aas;
	}





}
