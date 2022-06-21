package com.player.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
enum AASRepoState
{
	ADD_ARTIST, ADD_ALBUM, ADD_SONG;
}
public class AASContainer {
	private ArtistSP artist;
	private List<AlbumSP> albums;
	private List<SongSP> songs;
	private AASRepoState[] repoStateArr;
	
	public AASContainer()
	{		
		this.artist = null;
		repoStateArr = AASRepoState.values();
	}	
	public AASContainer(ArtistSP artist) {
		super();		
		this.artist = artist;
		repoStateArr = AASRepoState.values();
	}		
	public static Integer emptyInteger()
	{
		return Integer.valueOf(-1);	
	}
	
	public static String emptyString()
	{
		return null;
	}
	
	public static Long emptyLong()
	{
		return null;
	}
	
	public static LocalDateTime emptyLocalDateTime()
	{
		return null;
	}
	public static Object emptyDefault()
	{
		return null;
	}

	public AASRepoState[] getRepoStates() {
		return repoStateArr;
	}

	public void setRepoStates(AASRepoState[] repoStateArr) {
		this.repoStateArr = repoStateArr;
	}
	
//	private AlbumSP album;
//	private SongSP song;
//
//	public AASContainer()
//	{
//		this.artist = null;
//		this.album = null;
//		this.song = null;
//
//	}
	public AASContainer(ArtistSP artist, List<AlbumSP> album, List <SongSP> song) {
		super();
		this.artist = artist;
		this.albums = album;
		this.songs = song;
	}

	public ArtistSP getArtist() {
		return artist;
	}
	public void setArtist(ArtistSP artist) {
		this.artist = artist;
	}
	public List<AlbumSP> getAlbums() {
		return albums;
	}
	public void setAlbums(List<AlbumSP> albums) {
		this.albums = albums;
	}
	public List<SongSP> getSongs() {
		return songs;
	}
	public void setSongs(List<SongSP> songs) {
		this.songs = songs;
	}
	
	public boolean isMissingElements()
	{
		return true;
	}		
}

			
			

