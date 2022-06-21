package com.player.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.player.model.beanless.DataId;

@Entity
@Table(name = "artistsp")
public class ArtistSP  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", columnDefinition = "BINARY(16)")
	private UUID id;
	@Column(unique=true)
	private String artistName;
	private LocalDateTime startYear;
	private String imgPath;
	private String genre;
	private Long totalViews;
//	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<AlbumSP> albums;
//	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<SongSP> singlesSongs;
	public ArtistSP()
	{
		artistName = null;
		startYear = null;
		imgPath = null;
		genre = null;
		totalViews = -1L;
		albums = null;
	}
	
	public ArtistSP(UUID id, String artistName, LocalDateTime startYear, String imgPath, String genre) {
		super();
		this.id = id;
		this.artistName = artistName;
		this.startYear = startYear;
		this.imgPath = imgPath;
		this.genre = genre;
		this.totalViews = totalViews;
	}
	public ArtistSP(String artistName, LocalDateTime startYear, String imgPath, String genre, Long totalViews) {
		super();
		this.artistName = artistName;
		this.startYear = startYear;
		this.imgPath = imgPath;
		this.genre = genre;
		this.totalViews = totalViews;
		albums = new ArrayList();
	}
	public ArtistSP newFilledArtist(ArtistSP a)
	{
		String an = (artistName == null || artistName != a.artistName)? a.artistName : artistName;
		LocalDateTime sy = (startYear == null || startYear != a.startYear  )? a.startYear:startYear;
		String ip = (imgPath == null || imgPath != a.imgPath )?a.imgPath:imgPath;
		String g = (genre == null || genre != a.genre )?a.genre:genre;
		Long tv = (totalViews == null || totalViews != a.totalViews )?a.totalViews:totalViews;
		
		return new ArtistSP(an,sy,ip, g, tv);
		
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public LocalDateTime getStartYear() {
		return startYear;
	}

	public void setStartYear(LocalDateTime startYear) {
		this.startYear = startYear;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public long getTotalViews() {
		return totalViews;
	}

	public void setTotalViews(long totalViews) {
		this.totalViews = totalViews;
	}
	
	 
	public List<AlbumSP> getAlbums() {
		return albums;
	}


	public void setAlbums(List<AlbumSP> albums) {
		this.albums = albums;
	}
	
	
	/*
	 * public List<SongSP> getSinglesSongs() { return singlesSongs; }
	 * 
	 * 
	 * public void setSinglesSongs(List<SongSP> singlesSongs) { this.singlesSongs =
	 * singlesSongs; }
	 */

	public void setTotalViews(Long totalViews) {
		this.totalViews = totalViews;
	}
	

	public List<SongSP> getSinglesSongs() {
		return singlesSongs;
	}

	public void setSinglesSongs(List<SongSP> singlesSongs) {
		this.singlesSongs = singlesSongs;
	}

	@Override
	public String toString() {
		return "Artist [id=" + id + ", artistName=" + artistName + ", startYear=" + startYear + ", imgPath=" + imgPath
				+ ", genre=" + genre + "]";
	}



	
}
