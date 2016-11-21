package com.savingstream.tracker.core.http.parser;

import com.savingstream.tracker.core.data.format.Formatter;
import com.savingstream.tracker.core.data.model.Entity;
import com.savingstream.tracker.core.data.model.Field;
import com.savingstream.tracker.core.data.model.Results;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class HtmlTableParser implements HtmlParser
{
    private Formatter<Object> valueFormatter;

    @Override
    public Results parse(final String htmlPage)
    {
        final Results results = new Results();

        try
        {
            final Document doc = Jsoup.parse(htmlPage);

            final List<String> fieldsNames = doc.getElementsByTag("table").first()
                    .getElementsByTag("thead").first()
                    .getElementsByTag("tr").first()
                    .getElementsByTag("th").stream()
                    .map(cellHeader -> cellHeader.getAllElements().last().unwrap().toString().trim())
                    .collect(Collectors.toList());

            doc.getElementsByTag("table").first().getElementsByTag("tbody").first().getElementsByTag("tr").forEach(row ->
            {
                final Elements cells = row.getElementsByTag("td");
                if (cells.size() == fieldsNames.size())
                {
                    final Entity entity = new Entity();

                    for (int index = 0; index < cells.size(); index++)
                    {
                        final Element cell = cells.get(index);
                        final String stringValue = Optional.ofNullable(cell.getElementsByTag("a").first()).map(element -> element.attr("href")).orElse(cell.unwrap().toString());
                        final Object value = getValueFormatter().format(stringValue.trim());
                        final Field field = new Field(fieldsNames.get(index), value.getClass());

                        entity.getAttributes().put(field, value);
                    }

                    results.add(entity);
                }
            });
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return results;
    }

    public Formatter<Object> getValueFormatter()
    {
        return valueFormatter;
    }

    @Required
    public void setValueFormatter(final Formatter<Object> valueFormatter)
    {
        this.valueFormatter = valueFormatter;
    }
}
