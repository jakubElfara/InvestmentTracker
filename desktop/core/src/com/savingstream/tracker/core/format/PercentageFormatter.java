package com.savingstream.tracker.core.format;

import com.savingstream.tracker.core.utils.NumberUtils;

import java.math.BigDecimal;
import java.util.regex.Matcher;

public class PercentageFormatter extends RegexFormatter<BigDecimal>
{
    @Override
    protected BigDecimal formatValue(final Matcher matcher)
    {
        return BigDecimal.valueOf(NumberUtils.parseDouble(matcher.group(1)));
    }
}