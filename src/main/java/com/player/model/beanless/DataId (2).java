package com.player.model.beanless;

import java.util.StringJoiner;
import java.util.UUID;

public class DataId {
    private UUID uuid;
    private Long longid;
    public DataId()
    {
    
    }
    public DataId(UUID id) {
        this.uuid = id;
    }
    
    public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public long getLongId() {
		return longid;
	}
	public void setLongId(Long longid) {
		this.longid = longid;
	}
	public String UUIDWithoutDashes()
    {
    	return uuid.toString().replaceAll("-", "");
    }
    
    @Override
    public String toString() {
        return new StringJoiner(", ", DataId.class.getSimpleName() + "[", "]")
                .add(String.format("id=%s", uuid))
                .toString();
    }
}