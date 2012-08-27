package com.pilgrim_lifestyle.model.eventer.personInfomation.contact;

import com.pilgrim_lifestyle.model.eventer.personInfomation.contact.MailAddress;
import com.pilgrim_lifestyle.model.eventer.personInfomation.contact.TelephoneNumber;

import javax.validation.Valid;

import lombok.Data;
import lombok.NoArgsConstructor;

public @Data @NoArgsConstructor class Contact
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

    public static Contact draft()
    {
        MailAddress mailAddress = new MailAddress( "" );

        TelephoneNumber telephoneNumber = new TelephoneNumber( "" );

        return new Contact( mailAddress, telephoneNumber );
    }

}
