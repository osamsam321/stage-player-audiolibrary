package com.player.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.player.jsondbcm.dao.ArtistSPJSONDBCMRepo;
import com.player.jsondbcm.dao.RelaseSPJSONDBCMRepo;
import com.player.jsondbcm.dao.TrackSPJSONDBCMRepo;
import com.player.model.JSONDBCM;

@Component
public class MBBaseJC {
	@Autowired
	JSONDBCM jsonDBCM;
	@Autowired
	ArtistSPJSONDBCMRepo artistRepo;

	
	public MBBaseJC(MBBaseQueryAndJSONBuilder builder)
	{
		this.jsonDBCM = builder.jsonDBCM;
	}
	public MBBaseJC buildDBCM(MBBaseJC builder)
	{
		return builder;
	}
	public JSONDBCM getJsonDBCM() {
		return jsonDBCM;
	}

	public void setJsonDBCM(JSONDBCM jsonDBCM) {
		this.jsonDBCM = jsonDBCM;
	}

	public ArtistSPJSONDBCMRepo getArtistRepo() {
		return artistRepo;
	}

	public void setArtistRepo(ArtistSPJSONDBCMRepo artistRepo) {
		this.artistRepo = artistRepo;
	}
	@Component
	public  static class MBBaseQueryAndJSONBuilder
	{
		@Autowired
		JSONDBCM jsonDBCM;
		 @Autowired
		private ArtistSPJSONDBCMRepo artistRepo;
		 @Autowired
		private TrackSPJSONDBCMRepo trackRepo;
		 @Autowired
		 private RelaseSPJSONDBCMRepo releaseRepo;
		 
		public MBBaseQueryAndJSONBuilder()
		{
			 jsonDBCM = new JSONDBCM();
		}
		public MBBaseQueryAndJSONBuilder(JSONDBCM jsonDBCM)
		{
			this.jsonDBCM = jsonDBCM;
		}
		public MBBaseQueryAndJSONBuilder getAllArtistWithId(List<Long> ids)
		{
			 jsonDBCM.add(artistRepo.getArtist(ids));
			 return this;
		}
		public MBBaseQueryAndJSONBuilder getAllArtistWithId(Long id)
		{
			jsonDBCM.add(artistRepo.getArtist(id));
			 return this;
		}
		public MBBaseQueryAndJSONBuilder getTracksWithId(List<Long> ids)
		{
			 jsonDBCM.add(trackRepo.getTracks(ids));
			 return this;
		}
		public MBBaseQueryAndJSONBuilder getTrackWithId(Long id)
		{
			jsonDBCM.add(trackRepo.getTrack(id));
			 return this;
		}
		public MBBaseQueryAndJSONBuilder getReleasesWithId(List<Long> ids)
		{
			 jsonDBCM.add(releaseRepo.getReleases(ids));
			 return this;
		}
		public MBBaseQueryAndJSONBuilder getReleaseWithId(Long id)
		{
			jsonDBCM.add(releaseRepo.getRelease(id));
			 return this;
		}
		public MBBaseQueryAndJSONBuilder newJSONDBCM()
		{
			jsonDBCM.newJSONDBCM();
			return this;
		} 
		public JSONDBCM getArtistSpHomePageWithArtistId(Long id)
		{
			return null;
		}
		public JSONDBCM GetTopTenTracks()
		{
			return null;
		}
		public MBBaseJC build()
		{
			return new MBBaseJC(this);
		}
		public JSONDBCM getJsonDBCM() {
			return jsonDBCM;
		}

	
		
	}
}
