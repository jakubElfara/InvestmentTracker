package com.savingstream.tracker.core.data.model;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

import static java.util.Objects.isNull;

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

    public Money divide(Money money)
    {
        checkMatchingCurrencies(money);

        return new Money(this.getValue().divide(money.getValue()), this.getCurrency());
    }

    public Money multiply(Money money)
    {
        checkMatchingCurrencies(money);

        return new Money(this.getValue().multiply(money.getValue()), this.getCurrency());
    }

    public Money subtract(Money money)
    {
        checkMatchingCurrencies(money);

        return new Money(this.getValue().subtract(money.getValue()), this.getCurrency());
    }

    public Money add(Money money)
    {
        checkMatchingCurrencies(money);

        return new Money(this.getValue().add(money.getValue()), this.getCurrency());
    }

    private void checkMatchingCurrencies(final Money money)
    {
        if (!this.getCurrency().equals(money.getCurrency()))
        {
            throw new UnsupportedOperationException("Multiple currency operation not supported");
        }
    }

    public int compareTo(Money money)
    {
        checkMatchingCurrencies(money);

        return (isNull(this.getValue())) ? -1 :
                (isNull(money.getValue())) ? 1 :
                        this.getValue().compareTo(money.getValue());
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