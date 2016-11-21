package com.savingstream.tracker.core.data.format;

import com.savingstream.tracker.core.data.model.Money;
import com.savingstream.tracker.core.utils.NumberUtils;

import java.util.regex.Matcher;

public class MoneyFormatter extends RegexFormatter<Money>
{
    @Override
    protected Money formatValue(final Matcher matcher)
    {
        return new Money(NumberUtils.parseDouble(matcher.group(2)));
    }
}