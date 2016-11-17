package com.savingstream.tracker.core.model;

import java.util.Date;

public class LoanPart extends Item
{
    private Loan loan;

    private Money amount;

    private Money interest;

    private Date startDate;

    private Date endDate;

    public LoanPart(final Integer id)
    {
        super(id);
    }
}
