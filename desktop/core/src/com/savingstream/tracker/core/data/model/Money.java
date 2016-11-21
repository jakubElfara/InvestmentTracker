package com.savingstream.tracker.core.data.model;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

public class Money
{
    private static final Locale DEFAULT_LOCALE = Locale.UK;

    private BigDecimal value;

    private Currency currency;

    public Money(final BigDecimal value, final Currency currency)
    {
        setValue(value);
        setCurrency(currency);
    }

    public Money(final String value, final Currency currency)
    {
        this(new BigDecimal(value), currency);
    }

    public Money(final Double value, final Currency currency)
    {
        this(BigDecimal.valueOf(value), currency);
    }

    public Money(final BigDecimal value)
    {
        this(value, Currency.getInstance(DEFAULT_LOCALE));
    }

    public Money(final Double value)
    {
        this(BigDecimal.valueOf(value));
    }

    public Money divide(Money divisor)
    {
        checkMatchingCurrencies(divisor);

        return new Money(this.getValue().divide(divisor.getValue()), this.getCurrency());
    }

    public Money multiply(Money divisor)
    {
        checkMatchingCurrencies(divisor);

        return new Money(this.getValue().multiply(divisor.getValue()), this.getCurrency());
    }

    public Money subtract(Money divisor)
    {
        checkMatchingCurrencies(divisor);

        return new Money(this.getValue().subtract(divisor.getValue()), this.getCurrency());
    }

    public Money add(Money divisor)
    {
        checkMatchingCurrencies(divisor);

        return new Money(this.getValue().add(divisor.getValue()), this.getCurrency());
    }

    private void checkMatchingCurrencies(final Money divisor)
    {
        if (!this.getCurrency().equals(divisor.getCurrency()))
        {
            throw new UnsupportedOperationException("Multiple currency operation not supported");
        }
    }

    public BigDecimal getValue()
    {
        return value;
    }

    public Currency getCurrency()
    {
        return currency;
    }

    public void setValue(final BigDecimal value)
    {
        this.value = value.setScale(2);
    }

    public void setCurrency(final Currency currency)
    {
        this.currency = currency;
    }

    public String toString()
    {
        return String.format("%s %s", getValue().toString(), getCurrency().getSymbol());
    }
}