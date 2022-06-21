package com.player.model.beanless;

import java.util.StringJoiner;
import java.util.UUID;

public class DataId {
    private UUID id;
    public DataId()
    {
    
    }
    public DataId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
    public String UUIDWithoutDashes()
    {
    	return id.toString().replaceAll("-", "");
    }
    @Override
    public String toString() {
        return new StringJoiner(", ", DataId.class.getSimpleName() + "[", "]")
                .add(String.format("id=%s", id))
                .toString();
    }
}