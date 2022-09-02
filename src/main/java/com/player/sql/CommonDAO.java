package com.player.sql;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.player.model.AASContainer;
import com.player.model.AASSingleFieldContainer;
import com.player.model.AlbumSP;
import com.player.model.ArtistSP;
import com.player.model.SongSP;
import com.player.model.TopSongs;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;


@Repository 
@Transactional
public class CommonDAO {
	@Autowired
	JdbcTemplate jt;
	
	public List<AASSingleFieldContainer> findTopSongsForAASSingleFieldContainer(int amount)
	{
		String sql = "select * from songsp song \r\n"
				+ "left join songsp_albums sa on sa.songsp_songsp_id = song.songsp_id  \r\n"
				+ "left join albumsp album on album.albumsp_id  = sa.albums_albumsp_id \r\n"
				+ "left join artistsp a on song.artistsp_id = a.artistsp_id \r\n"
				+ "order by song.listen_count  desc limit " + amount;
		List<AASSingleFieldContainer> aASSnigleFieldContainerList = jt.query(sql, new RowMapper<AASSingleFieldContainer>()  {

			@Override
			public AASSingleFieldContainer mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new AASSingleFieldContainer(
						new SongSP(	
								
//								public SongSP(Long id, String songName, String path, Float seconds, Long songLengthMs, Long views,
//										List<AlbumSP> albums, ArtistSP artist) {
//									super();
//									this.id = id;
//									this.songName = songName;
//									this.path = path;
//									this.seconds = seconds;
//									this.songLengthMs = songLengthMs;
//									this.views = views;
//									this.albums = albums;
//									this.artist = artist;
//								}
									rs.getLong("songsp_id"),
									rs.getString("song_path"),
									rs.getString("song_name"),
									rs.getFloat("song_length"),
									rs.getLong("song_length_ms"),
									rs.getLong("listen_count"),
									null, //keep empty id value for album list
									null
								),
						
						new AlbumSP(
									rs.getLong("albumsp_id"),
									rs.getString("album_name"),
									rs.getTimestamp("start_dt").toLocalDateTime(),
									rs.getString("albumsp_img_identifer"),
									null //empty for song list							
								),
						
						new ArtistSP(
									rs.getLong("artistsp_id"),
									rs.getString("artist_name"),
									rs.getTimestamp("artist_start_dt").toLocalDateTime(),
									rs.getString("artist_img_path"),
									rs.getString("genre"),
									rs.getLong("total_views")						
								)				
				);
			
			
			}
			
		});
	
    		

		return aASSnigleFieldContainerList;
	}
	
	public List<TopSongs> findTopSongs(int amount)
	{
		String sql = "select artist_name, song_name, albumsp_img_identifier, song_identifier from songsp song \r\n"
				+ "left join songsp_albums sa on sa.songsp_songsp_id = song.songsp_id  \r\n"
				+ "left join albumsp album on album.albumsp_id  = sa.albums_albumsp_id \r\n"
				+ "left join artistsp a on song.artistsp_id = a.artistsp_id \r\n"
				+ "order by song.listen_count desc limit " + amount;
		List<TopSongs> aASSnigleFieldContainerList = jt.query(sql, new RowMapper<TopSongs>()  {

			@Override
			public TopSongs mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new TopSongs(	
									rs.getString("artist_name"),
									rs.getString("albumsp_img_identifier"),
									rs.getString("song_name"),
									rs.getString("song_identifier")
									
								);				
			
			
			}
			
		});
	
    		

		return aASSnigleFieldContainerList;
	}
	

	   
	   

}
