package com.savingstream.tracker.core.format;

import org.springframework.beans.factory.annotation.Required;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class RegexFormatter<TYPE> implements Formatter<TYPE>
{
    private Pattern regexPattern;

    public boolean isFormattable(String value)
    {
        return regexPattern.matcher(value).find();
    }

    public TYPE format(String value)
    {
        final Matcher matcher = regexPattern.matcher(value);
        matcher.find();
        return formatValue(matcher);
    }

    protected abstract TYPE formatValue(final Matcher matcher);

    @Required
    public void setRegularExpression(final String regularExpression)
    {
        this.regexPattern = Pattern.compile(regularExpression);
    }
}