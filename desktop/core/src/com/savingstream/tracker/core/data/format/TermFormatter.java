package com.savingstream.tracker.core.data.format;

import com.savingstream.tracker.core.utils.NumberUtils;

import java.util.regex.Matcher;

public class TermFormatter extends RegexFormatter<Integer>
{
    @Override
    protected Integer formatValue(final Matcher matcher)
    {
        return NumberUtils.parseInteger(matcher.group(1)).intValue();
    }
}