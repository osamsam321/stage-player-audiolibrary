package com.player.jsondbcm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Test {
@Autowired
ArtistSPJSONDBCMRepo a;
public void test()
{
	this.a.getArtist(1L);
}
}
