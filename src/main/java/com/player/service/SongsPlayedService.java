package com.player.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.player.model.SongSP;
import com.player.model.elw.SongsPlayed;
import com.player.repo.SongsPlayedRepo;

@Service
public class SongsPlayedService {
	Logger log = LogManager.getLogger(SongsPlayedService.class);
	@Autowired
	SongsPlayedRepo spRepo;
	
	public Optional<SongsPlayed> getSongsPlayedBySongPlayedId(Long spid)
	{
		return spRepo.findById(spid);
	}
	public Optional<List<SongsPlayed>> getSongsPlayedByUserId(Long userID)
	{
		log.info("Song played object with userid as: " + userID);
		return Optional.of(spRepo.findByuserid(userID));
	}
	public void saveSongsPlayed(SongsPlayed sp)
	{
		log.info("Song played object with userid as: " + sp.getUserid().toString());
		 spRepo.save(sp);
	}
	
	

	
	

}
