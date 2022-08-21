package com.player.sql;

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
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;


@Repository 
@Transactional
public class CommonDAO {
	@Autowired
	JdbcTemplate jt;
	
	public List<AASSingleFieldContainer> findTopTenSongs()
	{
		String sql = "select * from songsp song \r\n"
				+ "left join songsp_albums sa on sa.songsp_songsp_id = song.songsp_id  \r\n"
				+ "left join albumsp album on album.albumsp_id  = sa.albums_albumsp_id \r\n"
				+ "left join artistsp a on song.artistsp_id = a.artistsp_id \r\n"
				+ "order by song.listen_count  desc limit 10";
		List<AASSingleFieldContainer> aASSnigleFieldContainerList = jt.query(sql, new RowMapper<AASSingleFieldContainer>()  {

			@Override
			public AASSingleFieldContainer mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new AASSingleFieldContainer(
						new SongSP(	
									rs.getLong("songsp_id"),
									rs.getString("song_path"),
									rs.getString("song_name"),
									rs.getFloat("song_length"),
									rs.getLong("listen_count"),
									null //keep empty id value for album list
								),
						
						new AlbumSP(
									rs.getLong("albumsp_id"),
									rs.getString("album_name"),
									rs.getTimestamp("start_dt").toLocalDateTime(),
									rs.getString("albumsp_img_path"),
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
	public AASContainer findTopHundredSongs()
	{
		
		return null;
	}
}
