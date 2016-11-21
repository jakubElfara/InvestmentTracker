package com.savingstream.tracker.core.utils;

import com.savingstream.tracker.core.configuration.ConfigurationManager;
import com.savingstream.tracker.core.context.ApplicationContext;
import org.apache.commons.configuration2.Configuration;

public class ConfigurationUtils
{
    public final static Configuration defaultConfiguration()
    {
        return ApplicationContext.getBean("configurationManager", ConfigurationManager.class).getConfiguration();
    }
}