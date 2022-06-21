package com.player.beans;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import com.player.model.beanless.DataId;

import java.util.UUID;




@Component 

public class StringToUserIdConverter implements Converter<String, DataId> { 
//	@Override
//	public DataId convert(@NonNull String uuid) {
//		return new DataId(UUID.fromString(uuid));
//	}
  @Override
	public DataId convert(@NonNull String uuid) {
		return new DataId(UUID.fromString(uuid));    /*. replaceFirst( 
		        "(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)", "$1-$2-$3-$4-$5" 
			    ))); */
	}
}