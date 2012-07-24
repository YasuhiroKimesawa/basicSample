package com.pilgrim_lifestyle.model.eventer.contact;

import lombok.ToString;

@ToString
public class MailAddress
{
    private String mailAddress;

    public MailAddress( String mailAddress )
    {
        this.mailAddress = mailAddress;
    }
}
