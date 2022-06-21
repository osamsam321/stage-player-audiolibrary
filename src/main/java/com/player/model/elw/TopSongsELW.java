package com.player.model.elw;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.player.model.SongSP;

public class TopSongsELW {
	@Autowired
	private List<SongSP> topSongs;
	
	public TopSongsELW()
	{
		topSongs = new ArrayList<>();
	}
	public TopSongsELW(List<SongSP> topSongs)
	{
		this.topSongs = topSongs;
	}
	public List<SongSP> getTopSongs() {
		return topSongs;
	}
	public void setTopSongs(List<SongSP> topSongs) {
		this.topSongs = topSongs;
	}
	
	
}
