package com.savingstream.tracker.core.http.client;

import com.savingstream.tracker.core.configuration.ConfigurationManager;
import org.apache.commons.configuration2.Configuration;
import org.springframework.beans.factory.annotation.Required;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SavingStreamClient extends AbstractHttpClient
{
    private ConfigurationManager configurationManager;

    public static final String HOST = "host";
    public static final String LOGIN = "page.login";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";

    public static final String LOANS = "page.loans";
    public static final String LOANS_AVAILABLE = "page.loans.available";
    public static final String LOANS_LIVE = "page.loans.live";
    public static final String LOANS_PIPELINE = "page.loans.pipeline";
    public static final String LOANS_DEFAULT = "page.loans.default";
    public static final String LOANS_REPAID = "page.loans.repaid";
    public static final String LOANS_UPDATES = "page.loans.updates";

    public static final String MY_LOANS_LIVE = "page.myLoans.live";
    public static final String MY_LOANS_REPAID = "page.myLoans.repaid";
    public static final String MY_LOANS_SELLING = "page.myLoans.selling";
    public static final String MY_LOANS_SOLD = "page.myLoans.sold";
    public static final String MY_LOANS_UPDATES = "page.myLoans.updates";

    public static final String ACCOUNT_TRANSACTIONS = "page.account.transactions";
    public static final String ACCOUNT_DETAILS = "page.account.details";
    public static final String ACCOUNT_STATEMENT = "page.account.statement";
    public static final String ACCOUNT_REWARDS = "page.account.rewards";

    public boolean login(final String email, final String password) throws IOException
    {
        final Map<String, String> parametersMap = new HashMap<>();
        parametersMap.put(EMAIL, email);
        parametersMap.put(PASSWORD, password);

        post(url(LOGIN), parametersMap);
        post(url(LOANS), new HashMap<>());
        return post(url(LOANS_AVAILABLE), new HashMap<>()).returnContent().toString().contains("Logout");
    }

    public String browse(final String page) throws Exception
    {
        return get(url(page)).returnContent().toString();
    }

    protected String url(final String page)
    {
        final Configuration configuration = configurationManager.getConfiguration();
        return String.format("%s/%s", configuration.getString(HOST), configuration.getString(page));
    }

    @Required
    public void setConfigurationManager(final ConfigurationManager configurationManager)
    {
        this.configurationManager = configurationManager;
    }
}
