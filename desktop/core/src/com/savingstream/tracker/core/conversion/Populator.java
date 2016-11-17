package com.savingstream.tracker.core.conversion;

public interface Populator<SOURCE, TARGET>
{
    void populate(SOURCE source, TARGET target);
}