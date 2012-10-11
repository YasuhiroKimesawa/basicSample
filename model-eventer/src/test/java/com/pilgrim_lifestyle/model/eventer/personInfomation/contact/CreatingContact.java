package com.pilgrim_lifestyle.model.eventer.personInfomation.contact;

import java.util.Map;

import com.pilgrim_lifestyle.model.eventer.EventerData;

public class CreatingContact
{
    Map<EventerData.Data, String> eventerData;

    public static CreatingContact instansOf( Map<EventerData.Data, String> eventerData )
    {
        return new CreatingContact( eventerData );
    }

    private CreatingContact( Map<EventerData.Data, String> eventerData )
    {
        this.eventerData = eventerData;
    }

    public Contact createContact()
    {
        return new Contact( createMailAddress(), createTelephoneNumber() );
    }

    public TelephoneNumber createTelephoneNumber()
    {
        return new TelephoneNumber( eventerData.get( EventerData.Data.電話番号 ) );
    }

    public MailAddress createMailAddress()
    {
        return new MailAddress( eventerData.get( EventerData.Data.メールアドレス ) );
    }
}
