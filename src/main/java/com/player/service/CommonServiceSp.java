package com.player.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.player.model.AASContainer;
import com.player.model.AASSingleFieldContainer;
import com.player.model.TopSongs;
import com.player.sql.CommonDAO;

@Service
public class CommonServiceSp {
	@Autowired
	CommonDAO commonDAO;
	
	public Optional<List<AASSingleFieldContainer>> findTopTenSongsUsingAASSingleFieldContainer()
	{
		return Optional.of(commonDAO.findTopTenSongs());
	}
}
