package com.savingstream.tracker.core.data.model;

import java.math.BigDecimal;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.Objects.isNull;

public class Entity
{
    private String key;

    private Map<Field, Object> attributes = new LinkedHashMap<>();

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

    public int compareTo(final Entity entity, final Field sortField)
    {
        return compareFieldValues(sortField, this, entity);
    }

    private int compareFieldValues(final Field field, final Entity o1, final Entity o2)
    {
        final Object value1 = o1.getAttributes().get(field);
        final Object value2 = o2.getAttributes().get(field);

        return (isNull(value1)) ? -1 :
                (isNull(value2)) ? 1 :
                        field.getType().equals(Boolean.class) ? ((Boolean) value1).compareTo((Boolean) value2) :
                                field.getType().equals(String.class) ? ((String) value1).compareTo((String) value2) :
                                        field.getType().equals(Integer.class) ? ((Integer) value1).compareTo((Integer) value2) :
                                                field.getType().equals(BigDecimal.class) ? ((BigDecimal) value1).compareTo((BigDecimal) value2) :
                                                        field.getType().equals(Money.class) ? ((Money) value1).compareTo((Money) value2) :
                                                                field.getType().equals(URI.class) ? ((URI) value1).compareTo((URI) value2) : 0;
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