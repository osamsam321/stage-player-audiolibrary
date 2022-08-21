package com.player.model.cpw;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.player.model.ArtistSP;
import com.player.model.elw.AllAlbumsELW;
import com.player.model.elw.TopSongsELW;

public class ArtistHomePage {

	@Autowired
	TopSongsELW ts;
	@Autowired
	AllAlbumsELW aa;
	List topSongs;
	List albums;
	@Autowired
	ArtistSP artist;
	
	public ArtistHomePage() {}
	public ArtistHomePage(TopSongsELW ts, AllAlbumsELW aa, ArtistSP artist )
	{
		this.topSongs = ts.getTopSongs();
		this.albums = aa.getAlbums();
		this.artist = artist;
	}
	public ArtistHomePage(ArtistSP artist)
	{
		this.artist = artist;
	}
	public TopSongsELW getTs() {
		return ts;
	}
	public void setTs(TopSongsELW ts) {
		this.ts = ts;
	}
	public AllAlbumsELW getAa() {
		return aa;
	}
	public void setAa(AllAlbumsELW aa) {
		this.aa = aa;
	}
	public ArtistSP getArtist() {
		return artist;
	}
	public void setArtist(ArtistSP artist) {
		this.artist = artist;
	}
	public List getTopSongs() {
		return topSongs;
	}
	public void setTopSongs(List topSongs) {
		this.topSongs = topSongs;
	}
	public List getAlbums() {
		return albums;
	}
	public void setAlbums(List albums) {
		this.albums = albums;
	}
	@Override
	public String toString() {
		return "ArtistHomePage [ts=" + ts + ", aa=" + aa + ", topSongs=" + topSongs + ", albums=" + albums + ", artist="
				+ artist + "]";
	}
	
	
	
	
	
	
}
