package com.nortal.commander;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Environment {
    private Map<String, String> properties = new LinkedHashMap<>();
    private final long upTimeStart = System.currentTimeMillis();

    public Map<String, String> getProperties() {
        return properties;
    }

    public void addProperty(String key, String value) {
        this.properties.put(key, value);
    }

    public long getStartTime() {
        return upTimeStart;
    }

}
