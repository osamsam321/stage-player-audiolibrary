package com.player.jsondbcm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.player.model.JSONDBCM;
@Repository
public class RelaseSPJSONDBCMRepo {
	@Autowired
	private JdbcTemplate jt;
	
	public JSONDBCM getReleases(List<Long> idList)
	{
		String parameter = idList.toString().replace("[","").replace("]","");
		String sql = "SELECT * FROM musicbrainz_db.musicbrainz.release r WHERE id in (?)";
		return new JSONDBCM(jt.queryForList(sql, parameter));
	}
	public JSONDBCM getRelease(Long id)
	{
		String sql = "SELECT * FROM musicbrainz_db.musicbrainz.release r WHERE id = (?)";
		return new JSONDBCM(jt.queryForList(sql, id));
	}
}
