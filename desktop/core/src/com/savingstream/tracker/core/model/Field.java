package com.savingstream.tracker.core.model;

import java.math.BigDecimal;

public class Field
{
    public final static Field BOOLEAN = new Field(Boolean.class, false);

    public final static Field STRING = new Field(String.class, "");

    public final static Field INTEGER = new Field(Integer.class, 0);

    public final static Field BIG_DECIMAL = new Field(BigDecimal.class, 0.0);

    private String name;

    private Class type;

    private Object defaultValue;

    public Field(final Class type, final Object defaultValue)
    {
        this(null, type, defaultValue);
    }

    public Field(final String name, final Class type, final Object defaultValue)
    {
        this.name = name;
        this.type = type;
        this.defaultValue = defaultValue;
    }
}
