package com.pilgrim_lifestyle.model.eventer.contact;

import javax.validation.Valid;

import lombok.ToString;

@ToString
public class Contact
{
    @Valid
    private MailAddress mailAddress;

    @Valid
    private TelephoneNumber telephoneNumber;

    public Contact( MailAddress mailAddress, TelephoneNumber telephoneNumber )
    {
        this.mailAddress = mailAddress;
        this.telephoneNumber = telephoneNumber;
    }

}
