package com.player.model;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
public class TopSongs {
	static volatile List<AASContainer> topTenSongsList;
	static volatile List<AASContainer> topHundredSongsList;
}
