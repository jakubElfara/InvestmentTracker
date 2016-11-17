package com.savingstream.tracker.core.conversion;

public interface Converter<SOURCE, TARGET>
{
    TARGET covert(SOURCE source);

    void covert(SOURCE source, TARGET target);
}