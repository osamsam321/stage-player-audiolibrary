package com.player.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.player.beans.ID3VService;
import com.player.exception.ArtistException;
import com.player.model.ArtistSP;
import com.player.model.beanless.DataId;
import com.player.repo.ArtistRepo;

@Service
public class ArtistService {
	Logger log = LogManager.getLogger(ArtistService.class);
	@Autowired
	ArtistRepo repo;
	public void getName()
	{
		
	}
	public Optional<ArtistSP> getArtistContent(DataId id)
	{
		System.out.println("id: " + id.getLongId());
		System.out.println(Optional.ofNullable((repo.getArtistFromName("Ratt"))));
		return repo.findById(id.getLongId());
	}
	public Optional<ArtistSP> saveArtist(ArtistSP artist)
	{
		 return Optional.ofNullable(repo.save(artist));
	}
	public Optional<ArtistSP> getArtistFromName(String string)
	{
		 return Optional.ofNullable(repo.getArtistFromName(string));
	}
	public Optional<List<ArtistSP>> getAllArtist()
	{
		return Optional.ofNullable(repo.findAll());
	}
	public boolean existsByArtistName(String artistName)
	{		
		log.info("artistname in exist by artist name method: " + artistName);
		return repo.existByArtistName(artistName).isPresent();
	}
	

}
