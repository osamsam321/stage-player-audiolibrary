package com.player.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.player.model.AlbumSP;
import com.player.model.ArtistSP;
import com.player.model.SongSP;


public class AASMapper {
	
	public static ArtistSP getArtistSPMapper(ResultSet rs, int rowNum) throws SQLException
	{
		return new ArtistSPMapper().mapRow(rs, rowNum);
	}
	public static AlbumSP getAlbumSPMapper(ResultSet rs, int rowNum) throws SQLException
	{
		return new AlbumSPMapper().mapRow(rs, rowNum);
	}
	public static SongSP getSongSPMapper(ResultSet rs, int rowNum) throws SQLException
	{
		return new SongSPMapper().mapRow(rs, rowNum);
	}
}

class ArtistSPMapper implements RowMapper
{

	@Override
	public ArtistSP mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		ArtistSP ar = new ArtistSP();
		ar.setArtistName(rs.getString("ARTIST_NAME"));
		ar.setGenre(rs.getString("GENRE"));
		ar.setImgPath(rs.getString("IMG_PATH"));
		ar.setStartYear(rs.getDate("START_YEAR").toLocalDate().atStartOfDay());
		return ar;
	}
}
class AlbumSPMapper implements RowMapper
{

	@Override
	public AlbumSP mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		AlbumSP al = new AlbumSP();
		al.setAlbumName(rs.getString("ALBUM_NAME"));
		al.setArtist((ArtistSP) rs.getObject("	ARTISTSP_ID"));
		al.setImgPath(rs.getString("IMG_PATH"));
		al.setYear(rs.getDate("YEAR").toLocalDate().atStartOfDay());
		return al;
	}
}
class SongSPMapper implements RowMapper
{

	@Override
	public SongSP mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		SongSP song = new SongSP();
		song.setAlbums( (List<AlbumSP>) rs.getObject("ALBUMSP_ID"));
		song.setArtist((ArtistSP) rs.getObject("ARTISTSP_ID"));
		song.setPath(rs.getString("PATH"));
		song.setSeconds(rs.getFloat("SECONDS"));
		song.setSongName(rs.getString("SONG_NAME"));
		song.setViews(rs.getLong("VIEWS"));
		return song;
	}
}

