package com.savingstream.tracker.core.data.model;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class Field
{
    static Map<Class, Object> defaultMap = new HashMap<>();

    static
    {
        defaultMap.put(Boolean.class, Boolean.FALSE);
        defaultMap.put(String.class, StringUtils.EMPTY);
        defaultMap.put(Integer.class, Integer.valueOf(0));
        defaultMap.put(BigDecimal.class, BigDecimal.valueOf(0.0));
        defaultMap.put(Money.class, new Money(0.0));
        defaultMap.put(URI.class, URI.create("/"));
    }

    private String name;

    private Class type;

    private Object defaultValue;

    public Field(final String name, final Class type)
    {
        this.name = name;
        this.type = type;
        this.defaultValue = defaultMap.get(type);
    }

    public Class getType()
    {
        return type;
    }

    public String getName()
    {
        return name;
    }

    public Object getDefaultValue()
    {
        return defaultValue;
    }

    @Override
    public String toString()
    {
        return "Field{" +
                "defaultValue=" + defaultValue +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
        {
            return true;
        }

        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        final Field field = (Field) o;

        return new EqualsBuilder()
                .append(getName(), field.getName())
                .isEquals();
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder(17, 37)
                .append(getName())
                .toHashCode();
    }
}