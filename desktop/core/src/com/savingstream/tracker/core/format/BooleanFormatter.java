package com.savingstream.tracker.core.format;

import java.util.Arrays;
import java.util.List;

public class BooleanFormatter implements Formatter<Boolean>
{
    private static final String YES = "yes";

    private static final String NO = "no";

    private static final List<String> ACCEPTED_VALUES = Arrays.asList(YES, NO);

    public boolean isFormattable(String value)
    {
        return ACCEPTED_VALUES.contains(value.toLowerCase());
    }

    public Boolean format(String value)
    {
        return value.toLowerCase().equals(YES);
    }
}