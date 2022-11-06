package com.player.jsondbcm.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.player.model.JSONDBCM;

@Repository
public class ArtistSPJSONDBCMRepo {
	
	@Autowired
	private JdbcTemplate jt;

	public JSONDBCM getArtist(List<Long> idList)
	{
		String parameter = idList.toString().replace("[","").replace("]","");
		String sql = "SELECT * from	FROM musicbrainz.artist where id in (?)";
		return new JSONDBCM(jt.queryForList(sql, parameter));
	}
	public JSONDBCM getArtist(Long id)
	{
		String sql = "SELECT * FROM musicbrainz.artist where id = (?)";
		return new JSONDBCM(jt.queryForList(sql, id));
	}
}
