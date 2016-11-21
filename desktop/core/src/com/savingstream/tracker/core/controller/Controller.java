package com.savingstream.tracker.core.controller;

import com.savingstream.tracker.core.data.model.Results;
import com.savingstream.tracker.core.http.client.SavingStreamClient;
import com.savingstream.tracker.core.http.parser.HtmlTableParser;
import com.savingstream.tracker.core.utils.ConfigurationUtils;
import org.springframework.beans.factory.annotation.Required;

import java.io.IOException;

import static com.savingstream.tracker.core.http.client.SavingStreamClient.*;

public class Controller
{
    private SavingStreamClient httpClient;

    private HtmlTableParser htmlParser;

    public boolean login() throws IOException
    {
        final String login = ConfigurationUtils.defaultConfiguration().getString("users.user1.login");
        final String password = ConfigurationUtils.defaultConfiguration().getString("users.user1.password");

        return getHttpClient().login(login, password);
    }

    public Results getAvailableLoans() throws Exception
    {
        return getResults(LOANS_AVAILABLE);
    }

    public Results getMyLiveLoans() throws Exception
    {
        return getResults(MY_LOANS_LIVE);
    }

    public Results getMyRepaidLoans() throws Exception
    {
        return getResults(MY_LOANS_REPAID);
    }

    protected Results getResults(final String htmlPageUrl) throws Exception
    {
        final String htmlPageContent = getHttpClient().browse(htmlPageUrl);

        return getHtmlParser().parse(htmlPageContent);
    }

    public HtmlTableParser getHtmlParser()
    {
        return htmlParser;
    }

    @Required
    public void setHtmlParser(final HtmlTableParser htmlParser)
    {
        this.htmlParser = htmlParser;
    }

    public SavingStreamClient getHttpClient()
    {
        return httpClient;
    }

    @Required
    public void setHttpClient(final SavingStreamClient httpClient)
    {
        this.httpClient = httpClient;
    }
}