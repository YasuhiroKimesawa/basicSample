package com.pilgrim_lifestyle.model.eventer.contact;

import lombok.ToString;

@ToString
public class TelephoneNumber
{
    private String number;

    public TelephoneNumber( String number )
    {
        this.number = number;
    }
}
