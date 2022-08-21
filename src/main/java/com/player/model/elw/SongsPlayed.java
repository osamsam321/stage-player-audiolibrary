package com.player.model.elw;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity

@Table(name = "songsplayed", indexes = {@Index(name = "userid_index", columnList="userid", unique = true)})
public class SongsPlayed {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "songplayedid")
	Long songplayedid;
	@Column(name = "dtlistened",nullable = true)
	LocalDateTime dtlistened;
	@Column(name = "level",nullable = false)
	int level;	
	@Column(name = "userid", nullable = false)
	Long userid;
	@Column(name = "songid")
	Long songid;
	@Column(name = "artistid")
	Long artistid;
	@Column(name = "albumid")
	Long albumid;
	
	
	public Long getSongplayedid() {
		return songplayedid;
	}


	public void setSongplayedid(Long songplayedid) {
		this.songplayedid = songplayedid;
	}

	
	

	public LocalDateTime getDtlistened() {
		return dtlistened;
	}


	public void setDtlistened(LocalDateTime dtlistened) {
		this.dtlistened = dtlistened;
	}


	public Long getUserid() {
		return userid;
	}


	public void setUserid(Long userid) {
		this.userid = userid;
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	public Long getSongid() {
		return songid;
	}


	public void setSongid(Long songid) {
		this.songid = songid;
	}


	public Long getArtistid() {
		return artistid;
	}


	public void setArtistid(Long artistid) {
		this.artistid = artistid;
	}


	public Long getAlbumid() {
		return albumid;
	}


	public void setAlbumid(Long albumid) {
		this.albumid = albumid;
	}


	@Override
	public String toString() {
		return "SongsPlayed [songplayedid=" + songplayedid + ", datelistened=" + dtlistened + ", level=" + level
				+ ", songid=" + songid + ", artistid=" + artistid + ", albumid=" + albumid + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}	
	
	
}
