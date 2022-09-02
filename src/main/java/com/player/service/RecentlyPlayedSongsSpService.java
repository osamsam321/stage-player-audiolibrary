package com.player.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.player.model.RecentlyPlayedSongsSp;
import com.player.repo.RecentlyPlayedSongsSpRepo;

@Service
public class RecentlyPlayedSongsSpService {
	@Autowired
	RecentlyPlayedSongsSpRepo rpsRepo;
	public Optional<RecentlyPlayedSongsSp> FetchMostRecentlyPlayedWithUserId(Long userId)
	{
		return rpsRepo.findByUserId(userId);
	}
	public Optional<RecentlyPlayedSongsSp> save(RecentlyPlayedSongsSp recentlyPlayed) {
		// TODO Auto-generated method stub
		return Optional.of(rpsRepo.save(recentlyPlayed));
	}

}
