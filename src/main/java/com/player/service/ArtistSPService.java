package com.player.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.player.jsondbcm.dao.ArtistSPJSONDBCMRepo;
import com.player.model.ArtistSP;
import com.player.model.beanless.DataId;
import com.player.repo.ArtistRepo;

public class ArtistSPService {
	@Autowired
	ArtistSPJSONDBCMRepo artistDAO;
	@Autowired
	ArtistRepo artistRepo;
	
	public Optional<ArtistSP> getArtistContent(DataId id)
	{
		System.out.println("id: " + id.getLongId());
		System.out.println(Optional.ofNullable((artistRepo.getArtistFromName("Ratt"))));
		return artistRepo.findById(id.getLongId());
	}
	public Optional<ArtistSP> saveArtist(ArtistSP artist)
	{
		 return Optional.ofNullable(artistRepo.save(artist));
	}
	public Optional<ArtistSP> getArtistFromName(String string)
	{
		 return Optional.ofNullable(artistRepo.getArtistFromName(string));
	}
	public Optional<List<ArtistSP>> getAllArtist()
	{
		return Optional.ofNullable(artistRepo.findAll());
	}
	public boolean existsByArtistName(String artistName)
	{		
		return artistRepo.existByArtistName(artistName).isPresent();
	}
}
