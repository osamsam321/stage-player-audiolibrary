package com.player.beans.dbload.spotifyapi;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.hc.core5.http.ParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.player.beans.DbAASQueue;
import com.player.beans.IAASService;
import com.player.beans.dbload.api.genius.GeniusApiJSONRWService;
import com.player.model.AASContainer;
import com.player.model.AlbumSP;
import com.player.model.ArtistSP;
import com.player.model.SongSP;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.Album;
import se.michaelthelin.spotify.model_objects.specification.AlbumSimplified;
import se.michaelthelin.spotify.model_objects.specification.Artist;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.TrackSimplified;
import se.michaelthelin.spotify.requests.data.artists.GetArtistRequest;
import se.michaelthelin.spotify.requests.data.search.simplified.SearchArtistsRequest;
import se.michaelthelin.spotify.requests.data.search.simplified.SearchArtistsRequest.Builder;

public class SpotifyAPIJSONRWService implements IAASService{
	Logger log = LogManager.getLogger(SpotifyAPIJSONRWService.class);
	AASContainer aas;
	SpotifyApi builder;
	
	public void updateAASDataBySpotifyData() throws ParseException, SpotifyWebApiException, IOException
	{
//		SpotifyApi spotifyApi = new SpotifyApi.Builder()
//		        .setAccessToken("BQBs7f7iJbnhz_kh6jAuFc7tHBOjNPzFA9YKwm7PQQXBe0wYBiXMQRIUX3BD5xhXY34nr4t1KAHBqwMatPe9ZTsqC78rOYlpeAbTZxXMfdPkSuZDcd4guRQnVeVuBXf8oaStwASkn8")
//		        .build();
//		SearchArtistsRequest searchRequest= spotifyApi.
//				searchArtists(/*DbAASQueue.peek().getArtist().getArtistName() */ "pink floyd")
//				.build();
//		Paging<Artist> artists = searchRequest.execute();
//		Artist a = artists.getItems()[0];
		 aas = DbAASQueue.peekOrGetNew();
		 builder = new SpotifyApi.Builder()
		        .setAccessToken("BQBs7f7iJbnhz_kh6jAuFc7tHBOjNPzFA9YKwm7PQQXBe0wYBiXMQRIUX3BD5xhXY34nr4t1KAHBqwMatPe9ZTsqC78rOYlpeAbTZxXMfdPkSuZDcd4guRQnVeVuBXf8oaStwASkn8")
		        .build();
		
		Artist[] artistArr = builder
				.searchArtists(/*DbAASQueue.peek().getArtist().getArtistName() */ "pink floyd")
				.build().execute().getItems();
		configArtistSP( builder.getArtist(artistArr[0].getId()).build().execute());
		
		AlbumSimplified[] as = builder.searchAlbums(artistArr[0].getName()).build().execute().getItems();
		configAlbumSP(as);
		
		for(AlbumSimplified album: as)
		{
			configSongSP(builder.getAlbumsTracks(album.getId()).build().execute().getItems(), album.getName());
		}

		
		log.info("artist from spotify api" + artistArr[0].getName());
		
		
	}
	public void configArtistSP(Artist a)
	{
//		this.artistName = artistName;
//		this.startYear = startYear;
//		this.imgPath = imgPath;
//		this.genre = genre;
//		this.totalViews = totalViews;
		aas.setArtist(aas.getArtist().newFilledArtist(new ArtistSP(
				a.getName(), aas.emptyLocalDateTime(),
				a.getImages()[0].getUrl(), a.getGenres()[0], aas.emptyLong())
			
			));
	}
	public void configAlbumSP(AlbumSimplified[] albums)
	{
//		this.albumName = albumName;
//		this.year = year;
//		this.imgPath = imgPath;
//		this.artist = artist;
//		this.songs = songs;
//		for(AlbumSimplified a: albums)
//		{
//			aas.getArtist().getAlbums().add(new AlbumSP(
//						a.getName(), LocalDateTime.parse(a.getReleaseDate()), a.getImages()[0].getUrl(), 
//						aas.getArtist(), null
//					));
//		}				
				
	}
	public void configSongSP(TrackSimplified[] track, String albumName)
	{
//		int albumIndex = -1;
//		
//		for(int i = 0; i < aas.getArtist().getAlbums().size();i++)
//		{
//			if(aas.getArtist().getAlbums().get(i).equals(albumName))
//			{
//				albumIndex = i;
//				
//			}
//		}
////		this.songName = songName;
////		this.path = path;
////		this.seconds = seconds;
////		this.genre = genre;
////		this.views = views;
////		this.album = album;\
//		for(int i = 0; i < track.length;i++)
//		{
//			SongSP songSP = aas.getArtist().getAlbums().get(i).getSongs().get(i);
//			songSP.newFilledSong(new SongSP(
//				track[i].getName(), songSP.getPath(),(float) track[i].getDurationMs(), 
//				songSP.getViews(), List.of(aas.getArtist().getAlbums().get(albumIndex))
//					
//			));
//		}
//		

		
	}

	@Override
	public boolean execute() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void start() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
