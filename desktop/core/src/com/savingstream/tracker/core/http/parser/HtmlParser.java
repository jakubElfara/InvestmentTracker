package com.savingstream.tracker.core.http.parser;

import com.savingstream.tracker.core.data.model.Results;

public interface HtmlParser
{
    Results parse(final String htmlPage);
}
