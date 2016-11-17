package com.savingstream.tracker.core.format;

import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class ComposedFormatter implements Formatter<Object>
{
    private List<Formatter> formatters;

    @Override
    public boolean isFormattable(final String value)
    {
        return true;
    }

    @Override
    public Object format(final String value)
    {
        return formatters.stream()
                .filter(formatter -> formatter.isFormattable(value))
                .findFirst()
                .map(formatter -> formatter.format(value))
                .orElse(value);
    }

    @Required
    public void setFormatters(final List<Formatter> formatters)
    {
        this.formatters = formatters;
    }

    public List<Formatter> getFormatters()
    {
        return formatters;
    }
}
