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
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table( indexes = {@Index(name = "user_id_index",  columnList="user_id", unique = false)})
public class RecentlyPlayedSongsSp {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rps_id")
	private Long id;
	@Column(name = "user_id")
	private Long userId;
	@OneToMany(fetch= FetchType.LAZY, cascade = CascadeType.ALL)
	private List<SongSP> songsSp;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public List<SongSP> getSongsSp() {
		return songsSp;
	}
	public void setSongsSp(List<SongSP> songsSp) {
		this.songsSp = songsSp;
	}
	@Override
	public String toString() {
		return "RecentlyPlayedSongsSp [id=" + id + ", userId=" + userId + ", songsSp=" + songsSp + "]";
	}
	
	
	
	
}
