package com.savingstream.tracker.core.data.format;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;

public class UrlFormatter extends RegexFormatter<URI>
{
    @Override
    protected URI formatValue(final Matcher matcher)
    {
        try
        {
            return new URI(matcher.group());
        }
        catch (URISyntaxException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}