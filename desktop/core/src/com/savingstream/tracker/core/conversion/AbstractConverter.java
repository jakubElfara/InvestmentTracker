package com.savingstream.tracker.core.conversion;

import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public abstract class AbstractConverter<SOURCE, TARGET> implements Converter<SOURCE, TARGET>
{
    private Class<TARGET> targetClass;

    private List<Populator<SOURCE, TARGET>> populators;

    @Override
    public TARGET covert(final SOURCE source)
    {
        final TARGET target = createFromClass();

        covert(source, target);

        return target;
    }

    @Override
    public void covert(final SOURCE source, final TARGET target)
    {
        getPopulators().stream().forEach(populator -> populator.populate(source, target));
    }

    protected TARGET createFromClass()
    {
        try
        {
            return getTargetClass().newInstance();
        }
        catch (InstantiationException | IllegalAccessException e)
        {
            throw new RuntimeException(e);
        }
    }

    public List<Populator<SOURCE, TARGET>> getPopulators()
    {
        return populators;
    }

    @Required
    public void setPopulators(final List<Populator<SOURCE, TARGET>> populators)
    {
        this.populators = populators;
    }

    public Class<TARGET> getTargetClass()
    {
        return targetClass;
    }

    @Required
    public void setTargetClass(final Class<TARGET> targetClass)
    {
        this.targetClass = targetClass;
    }
}