package com.player.model;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Component
public class TopSongs implements ITopSongs{
	String artistName;
	String albumImg;
	String songName;
		
	
	public TopSongs() {
		super();
		this.artistName = "";
		this.albumImg = "";
		this.songName = "";
	}
	
	public TopSongs(String artistName, String albumImg, String songName) {
		super();
		this.artistName = artistName;
		this.albumImg = albumImg;
		this.songName = songName;
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
	
	
	
	
}



