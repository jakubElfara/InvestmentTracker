package com.savingstream.tracker.core.data.format;

public interface Formatter<TYPE>
{
    boolean isFormattable(String value);

    TYPE format(String value);
}