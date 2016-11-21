package com.savingstream.tracker.core.configuration.impl;

import com.savingstream.tracker.core.configuration.ConfigurationManager;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.springframework.beans.factory.annotation.Required;

public class DefaultConfigurationManager implements ConfigurationManager
{
    private String configurationFile = "config.properties";

    @Override
    public Configuration getConfiguration()
    {
        try
        {
            final Parameters params = new Parameters();
            final FileBasedConfigurationBuilder<FileBasedConfiguration> builder = new FileBasedConfigurationBuilder(PropertiesConfiguration.class)
                    .configure(params.properties().setFileName(configurationFile));

            return builder.getConfiguration();
        }
        catch (ConfigurationException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Required
    public void setConfigurationFile(final String configurationFile)
    {
        this.configurationFile = configurationFile;
    }
}
