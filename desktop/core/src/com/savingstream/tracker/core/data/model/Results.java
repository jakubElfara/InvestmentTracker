package com.savingstream.tracker.core.data.model;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Results
{
    private Set<Field> fields = new LinkedHashSet<>();

    private List<Entity> entities = new LinkedList<Entity>();

    public void add(Entity entity)
    {
        entities.add(entity);
        fields.addAll(entity.getAttributes().keySet());
    }

    public Set<Field> getFields()
    {
        return fields;
    }

    public List<Entity> getEntities()
    {
        return entities;
    }

    @Override
    public String toString()
    {
        return "Results\n{" +
                "fields: " + getFields() +
                "\nentities=[\n" +
                getEntities().stream()
                        .map(entity -> entity.getKey() + ":{" + entity.getAttributes().entrySet().stream().map(entry -> entry.getKey().getName() + "=" + entry.getValue()).collect(Collectors.joining(",")) + "}")
                        .collect(Collectors.joining("\n")) +
                "\n]}";
    }
}