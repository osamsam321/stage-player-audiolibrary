package com.player.service;

import org.springframework.stereotype.Component;

import com.player.model.JSONDBCM;
import com.player.service.MBBaseJC.MBBaseQueryAndJSONBuilder;

@Component
public class MBQueryBuilder {
	MBBaseJC mbjc;
	public MBQueryBuilder()
	{
		mbjc = null;
	}
	public JSONDBCM buildJSONDBMC(MBBaseQueryAndJSONBuilder mb)
	{
		if(mbjc == null)
		{
			return null; 

		}
		return null;
	}
}
