package com.player.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.RequiredArgsConstructor;
@Getter @Setter @NoArgsConstructor 
public class AASSingleFieldContainer {
	private SongSP songsp;
	private AlbumSP albumSP;
	private ArtistSP artistsp;
	
	public AASSingleFieldContainer(SongSP songsp, AlbumSP albumSP, ArtistSP artistsp) {
		super();
		this.songsp = songsp;
		this.albumSP = albumSP;
		this.artistsp = artistsp;
	}

	public SongSP getSongsp() {
		return songsp;
	}

	public void setSongsp(SongSP songsp) {
		this.songsp = songsp;
	}

	public AlbumSP getAlbumSP() {
		return albumSP;
	}

	public void setAlbumSP(AlbumSP albumSP) {
		this.albumSP = albumSP;
	}

	public ArtistSP getArtistsp() {
		return artistsp;
	}

	public void setArtistsp(ArtistSP artistsp) {
		this.artistsp = artistsp;
	}
	
	

	
}
