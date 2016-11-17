package com.savingstream.tracker.core.model;

import java.math.BigDecimal;

public class Loan extends Item
{
    private String name;

    private String details;

    private String image;

    private boolean drawnDown;

    private Integer remainingTerm;

    private BigDecimal monthlyInterest;

    private Money loanValue;

    private Money securityValue;

    private Money available;

    public Loan(final Integer id)
    {
        super(id);
    }

    public Money getLoanToValue()
    {
        return loanValue.divide(securityValue);
    }

    public BigDecimal getYearlyInterest()
    {
        return monthlyInterest.multiply(BigDecimal.valueOf(12));
    }

    public Money getAvailable()
    {
        return available;
    }

    public String getDetails()
    {
        return details;
    }

    public boolean isDrawnDown()
    {
        return drawnDown;
    }

    public String getImage()
    {
        return image;
    }

    public Money getLoanValue()
    {
        return loanValue;
    }

    public BigDecimal getMonthlyInterest()
    {
        return monthlyInterest;
    }

    public String getName()
    {
        return name;
    }

    public Integer getRemainingTerm()
    {
        return remainingTerm;
    }

    public Money getSecurityValue()
    {
        return securityValue;
    }

    public void setAvailable(final Money available)
    {
        this.available = available;
    }

    public void setDetails(final String details)
    {
        this.details = details;
    }

    public void setDrawnDown(final boolean drawnDown)
    {
        this.drawnDown = drawnDown;
    }

    public void setImage(final String image)
    {
        this.image = image;
    }

    public void setLoanValue(final Money loanValue)
    {
        this.loanValue = loanValue;
    }

    public void setMonthlyInterest(final BigDecimal monthlyInterest)
    {
        this.monthlyInterest = monthlyInterest;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public void setRemainingTerm(final Integer remainingTerm)
    {
        this.remainingTerm = remainingTerm;
    }

    public void setSecurityValue(final Money securityValue)
    {
        this.securityValue = securityValue;
    }
}