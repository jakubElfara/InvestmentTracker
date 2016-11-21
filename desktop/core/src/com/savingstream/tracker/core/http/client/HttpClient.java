package com.savingstream.tracker.core.http.client;

public interface HttpClient
{
    boolean login(final String email, final String password) throws Exception;

    String browse(final String page) throws Exception;
}
