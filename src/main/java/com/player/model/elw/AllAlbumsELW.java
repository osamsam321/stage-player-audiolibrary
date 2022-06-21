package com.player.model.elw;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.player.model.AlbumSP;

public class AllAlbumsELW {
	@Autowired
	private List<AlbumSP> albums;
	public AllAlbumsELW(List<AlbumSP> albums)
	{
		this.albums = albums;
	}
	public List<AlbumSP> getAlbums() {
		return albums;
	}
	public void setAlbums(List<AlbumSP> albums) {
		this.albums = albums;
	}

}
