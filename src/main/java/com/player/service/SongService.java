package com.player.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.player.model.AlbumSP;
import com.player.model.SongSP;
import com.player.model.beanless.DataId;
import com.player.model.elw.AllAlbumsELW;
import com.player.model.elw.TopSongsELW;
import com.player.repo.SongRepo;
@Service
public class SongService {
	@Autowired
	SongRepo repo;
	public Optional<SongSP> getSong(DataId id)
	{
		System.out.println("id" + id.getId());
		System.out.println("song field: " + repo.findById(id.getId()).get());
		return repo.findById(id.getId());
	}
	public Optional<TopSongsELW> getTopSongs(AllAlbumsELW albumELW)
	{
		TopSongsELW topSongs = new TopSongsELW();
		for(AlbumSP album: albumELW.getAlbums())
		{
			topSongs.getTopSongs().addAll((repo.getTopSongsFromAlbumID(album.getId())));
		}
		
		return Optional.ofNullable(topSongs);
	}
	public Optional<List<SongSP>> getAllSongs()
	{
		return Optional.ofNullable(repo.findAll());
	}
	public Optional<SongSP> saveSong(SongSP song)
	{
		return Optional.of(repo.save(song));
	}
	public Optional<List<SongSP>> saveAllSongs(List<SongSP> songs)
	{
		return Optional.of(repo.saveAll(songs));
	}
	public Optional<SongSP> getSongFromName(String string)
	{
		return Optional.ofNullable(repo.getSongFromName(string));
	}
	public boolean existBySongName(String songName)
	{
		return repo.existBySongName(songName).isPresent();
	}
}
