package com.pilgrim_lifestyle.model.eventer.contact;

import lombok.ToString;

@ToString
public class Contact
{
    private MailAddress mailAddress;

    private TelephoneNumber telephoneNumber;

    public Contact( MailAddress mailAddress, TelephoneNumber telephoneNumber )
    {
        this.mailAddress = mailAddress;
        this.telephoneNumber = telephoneNumber;
    }

}
