package com.player.model;


import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.player.model.beanless.DataId;
@Entity

@Table(name = "albumsp")
public class AlbumSP   {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "albumsp_id")
	private Long id;
	private String albumName;
	@Column(name="start_dt")
	private LocalDateTime year;
	@Column(name="albumsp_img_identifier", length = 100)
	private String imgPath;
//	@JsonBackReference
	@JsonIgnore 
	@ManyToOne(fetch= FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="artistsp_id")
	private ArtistSP artist;	
//	@JsonManagedReference
	@JsonIgnore 
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<SongSP> songs;
	
	
	public AlbumSP() {
		this.albumName = null;
		this.year = null;
		this.imgPath = null;
		this.artist = null;
		this.songs = null;
	}
	public AlbumSP(Long id, String albumName, LocalDateTime year, String imgPath, ArtistSP artist) {
		super();
		this.id = id;
		this.albumName = albumName;
		this.year = year;
		this.imgPath = imgPath;
		this.artist = artist;
	}
	public AlbumSP(String albumName, LocalDateTime year, String imgPath, ArtistSP artist) {
	super();
	this.albumName = albumName;
	this.year = year;
	this.imgPath = imgPath;
	this.artist = artist;
}
	public AlbumSP newFilledAlbum(AlbumSP a)
	{
		String an = (albumName.contentEquals("") || albumName != a.albumName )? a.albumName:albumName;
		LocalDateTime y = (year == null || year != a.year )?a.year:year;
		String path = (imgPath == null || imgPath != a.imgPath)? a.imgPath:imgPath;
		ArtistSP ar = (artist == null || artist != a.artist)? a.artist: artist;
		return new AlbumSP(an,y,path,ar);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public LocalDateTime getYear() {
		return year;
	}
	public void setYear(LocalDateTime year) {
		this.year = year;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public List<SongSP> getSongs() {
		return songs;
	}
	public void setSongs(List<SongSP> songs) {
		this.songs = songs;
	}
	
	public ArtistSP getArtist() {
		return artist;
	}
	public void setArtist(ArtistSP artist) {
		this.artist = artist;
	}
	@Override
	public String toString() {
		return "Album [id=" + id + ", albumName=" + albumName + ", year=" + year + ", imgPath=" + imgPath + ", artist="
				+ artist + ", songs=]";
	}
	
	
	
}
