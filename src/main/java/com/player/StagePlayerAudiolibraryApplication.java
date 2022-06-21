package com.player;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class StagePlayerAudiolibraryApplication {
	static Logger log = LogManager.getLogger(StagePlayerAudiolibraryApplication.class);
	public static void main(String[] args) {
		log.info("hey their program start");
		SpringApplication.run(StagePlayerAudiolibraryApplication.class, args);
	
	}


}
