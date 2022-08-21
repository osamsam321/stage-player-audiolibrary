package com.player.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.player.model.AlbumSP;
import com.player.model.ArtistSP;
import com.player.model.beanless.DataId;
import com.player.model.elw.AllAlbumsELW;
import com.player.repo.AlbumRepo;

@Service
public class AlbumService {
	@Autowired
	AlbumRepo repo;
	public Optional<AllAlbumsELW> getAllAlbumsFromArtistId(DataId id)
	{
		System.out.println("Album test: " + repo.getAllAlbumsFromArtistId(id.getLongId()));
		return Optional.ofNullable(new AllAlbumsELW(repo.getAllAlbumsFromArtistId(id.getLongId())));
	}
	public Optional<List<AlbumSP>> getAllAlbums()
	{
		return Optional.ofNullable(repo.findAll());
	}
	public Optional<AlbumSP> saveAlbum(AlbumSP album) {
		// TODO Auto-generated method stub
		return Optional.of(repo.save(album));
	}
	public Optional<List<AlbumSP>> saveAllAlbums (List <AlbumSP> album)
	{
		return Optional.of(repo.saveAll(album));
	}
	public Optional<AlbumSP> getAlbumFromName(String string)
	{
		return Optional.ofNullable(repo.getAlbumFromName(string));
	}
	public boolean existByAlbumName(String albumName)
	{
		try
		{
			return repo.existByAlbumName(albumName).isPresent();

		}
		catch(Exception e)
		{
			
		}
		return false;
	}
	
}	
