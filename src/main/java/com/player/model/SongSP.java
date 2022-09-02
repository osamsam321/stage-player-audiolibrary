package com.player.model;

import java.sql.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.player.model.beanless.DataId;
@Entity
@Table(name = "songsp")
public class SongSP  {
;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "songsp_id")
	private Long id;
	private String songName;
	@Column(name="song_identifier", unique = true)
	private String path;
	@Column(name = "song_length")
	private Float seconds;
	@Column(name = "song_length_ms")
	private Long songLengthMs;
	@Column(name="listen_count")
	private Long views;
//	@JsonBackReference
	@JsonIgnore 
	@ManyToMany(fetch= FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name ="albumsp_id")
	private List<AlbumSP> albums;
//	@JsonBackReference
	@JsonIgnore 
	@ManyToOne(fetch= FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name ="artistsp_id")
	private ArtistSP artist;
	public SongSP() {}
	
	public SongSP(Long id, String songName,
			String path, Float seconds,  Long views,
		List<AlbumSP> albums) {
		super();
		this.id = id;
		this.songName = songName;
		this.path = path;
		this.seconds = seconds;
		this.views = views;
		this.albums = albums;
	}
	public SongSP(String songName,
			String path, Float seconds,  Long views,
		List<AlbumSP> albums) {
		super();
		this.songName = songName;
		this.path = path;
		this.seconds = seconds;
		this.views = views;
		this.albums = albums;
	}
	
	public SongSP(Long id, String songName, String path, Float seconds, Long songLengthMs, Long views,
			List<AlbumSP> albums, ArtistSP artist) {
		super();
		this.id = id;
		this.songName = songName;
		this.path = path;
		this.seconds = seconds;
		this.songLengthMs = songLengthMs;
		this.views = views;
		this.albums = albums;
		this.artist = artist;
	}
	
	public SongSP(String title, String nanoidSongIdentifier, Object object, Long songLengthMs, long round,
			ArrayList arrayList) {
		// TODO Auto-generated constructor stub
	
		super();
		this.songName = songName;
		this.path = path;
		this.seconds = seconds;
		this.songLengthMs = songLengthMs;
		this.views = views;
		this.albums = albums;
		
	}

	public SongSP newFilledSong(SongSP s)
	{
		String sn = (songName == null || songName != s.songName )?s.songName:songName;
		String p = (path == null || path != s.path )?s.path:path;
		Float sec = (seconds == null || seconds != s.seconds )?s.seconds:seconds;
		Long v = (views == null || views != s.views )?s.views:views;
		List<AlbumSP> al = (albums == null || albums != s.albums)?s.albums:albums;
		
		return new SongSP(sn,p,sec,v,al);
				
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public float getSeconds() {
		return seconds;
	}
	public void setSeconds(float seconds) {
		this.seconds = seconds;
	}

	public Long getViews() {
		return views;
	}
	public void setViews(Long views) {
		this.views = views;
	}
	public List<AlbumSP> getAlbums() {
		return albums;
	}
	public void setAlbums(List<AlbumSP> list)
	{
		this.albums = list;
	}
	public ArtistSP getArtist() {
		return artist;
	}

	public void setArtist(ArtistSP artist) {
		this.artist = artist;
	}

	public void setSeconds(Float seconds) {
		this.seconds = seconds;
	}
	
	public Long getSongLengthMs() {
		return songLengthMs;
	}

	public void setSongLengthMs(Long songLengthMs) {
		this.songLengthMs = songLengthMs;
	}

	@Override
	public String toString() {
		return "Song [id=" + id + ", songName=" + ", path=" + path + ", seconds="
				+ seconds + ", views=" + views + "]";
	}

	
	
	

	
	
}
