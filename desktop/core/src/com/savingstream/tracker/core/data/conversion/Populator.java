package com.savingstream.tracker.core.data.conversion;

public interface Populator<SOURCE, TARGET>
{
    void populate(SOURCE source, TARGET target);
}