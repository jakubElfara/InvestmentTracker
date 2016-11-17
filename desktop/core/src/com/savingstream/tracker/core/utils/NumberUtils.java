package com.savingstream.tracker.core.utils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberUtils
{
    private static final NumberFormat ukNumberFormat = NumberFormat.getInstance(Locale.UK);

    public static Double parseDouble(final String value)
    {
        try
        {
            return ukNumberFormat.parse(value).doubleValue();
        }
        catch (ParseException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static Integer parseInteger(final String value)
    {
        try
        {
            return ukNumberFormat.parse(value).intValue();
        }
        catch (ParseException e)
        {
            throw new RuntimeException(e);
        }
    }
}
