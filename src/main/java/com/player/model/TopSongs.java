package com.player.model;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Component
public class TopSongs implements ITopSongs{
	String artistName;
	String albumImg;
	String songName;
	String audioIdentifier;	
	public TopSongs() {
		super();
		this.artistName = "";
		this.albumImg = "";
		this.songName = "";
		this.audioIdentifier = "";
	}
	
	public TopSongs(String artistName, String albumImg, String songName, String audioIdentifier) {
		super();
		this.artistName = artistName;
		this.albumImg = albumImg;
		this.songName = songName;
		this.audioIdentifier = audioIdentifier;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public String getAlbumImg() {
		return albumImg;
	}
	public void setAlbumImg(String albumImg) {
		this.albumImg = albumImg;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	
	public String getAudioIdentifier() {
		return audioIdentifier;
	}

	public void setAudioIdentifier(String audioIdentifier) {
		this.audioIdentifier = audioIdentifier;
	}

	public void method1()
	{
		
	}
	
	
	
	
}



