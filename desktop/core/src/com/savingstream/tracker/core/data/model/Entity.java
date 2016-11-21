package com.savingstream.tracker.core.data.model;

import java.util.HashMap;
import java.util.Map;

public class Entity
{
    private String key;

    private Map<Field, Object> attributes = new HashMap<>();

    public void setKey(final String key)
    {
        this.key = key;
    }

    public String getKey()
    {
        return key;
    }

    public void setAttributes(final Map<Field, Object> attributes)
    {
        this.attributes = attributes;
    }

    public Map<Field, Object> getAttributes()
    {
        return attributes;
    }

    @Override
    public String toString()
    {
        return "Entity{" +
                "key='" + key +
                "', attributes=" + attributes +
                '}';
    }
}