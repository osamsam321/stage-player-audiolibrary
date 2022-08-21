package com.player;

import java.util.UUID;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.bind.annotation.PathVariable;

import com.player.controllers.StageAudioPlayerController;
import com.player.model.beanless.DataId;
import com.player.model.cpw.ArtistHomePage;
import com.player.service.ArtistService;

import junit.framework.Assert;
@SpringBootTest
class StagePlayerAudiolibraryApplicationTests {

	@Test
	void contextLoads() {
	
	}


}
