package com.savingstream.tracker.core.http.client;

import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;

import java.io.IOException;
import java.util.Map;

public abstract class AbstractHttpClient implements HttpClient
{
    public Response get(final String page) throws IOException
    {
        return Request.Get(page).execute();
    }

    public Response post(final String page, final Map<String, String> formParameters) throws IOException
    {
        final Form form = Form.form();

        formParameters.entrySet().stream().forEach(formParam -> form.add(formParam.getKey(), formParam.getValue()));

        return Request.Post(page).bodyForm(form.build()).execute();
    }

    public abstract boolean login(final String email, final String password) throws Exception;

    public abstract String browse(final String page) throws Exception;
}