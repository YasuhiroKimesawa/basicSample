package com.pilgrim_lifestyle.model.eventer.personInfomation.contact;

import java.util.Map;

import com.pilgrim_lifestyle.model.eventer.EventerData;

public class CreatingContact
{
    public static Contact createContact( Map<EventerData.Data, String> eventerData )
    {
        return new Contact( createMailAddress( eventerData ), createTelephoneNumber( eventerData ) );
    }

    public static TelephoneNumber createTelephoneNumber( Map<EventerData.Data, String> eventerData )
    {
        return new TelephoneNumber( eventerData.get( EventerData.Data.電話番号 ) );
    }

    public static MailAddress createMailAddress( Map<EventerData.Data, String> eventerData )
    {
        return new MailAddress( eventerData.get( EventerData.Data.メールアドレス ) );
    }
}
