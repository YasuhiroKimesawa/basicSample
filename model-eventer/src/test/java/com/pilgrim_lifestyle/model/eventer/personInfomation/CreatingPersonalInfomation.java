package com.pilgrim_lifestyle.model.eventer.personInfomation;

import java.util.Map;

import com.pilgrim_lifestyle.model.eventer.EventerData;
import com.pilgrim_lifestyle.model.eventer.personInfomation.contact.Contact;
import com.pilgrim_lifestyle.model.eventer.personInfomation.contact.CreatingContact;

public class CreatingPersonalInfomation
{
    public static PersonalInfomation createPersonalInfomation( Map<EventerData.Data, String> eventerData )
    {
        Contact contact = CreatingContact.createContact( eventerData );

        return new PersonalInfomation( createProfile( eventerData ), contact );
    }

    public static Profile createProfile( Map<EventerData.Data, String> eventerData )
    {
        return new Profile( createPersonName( eventerData ) );
    }

    public static PersonName createPersonName( Map<EventerData.Data, String> eventerData )
    {
        return new PersonName( eventerData.get( EventerData.Data.姓 ), eventerData.get( EventerData.Data.名 ) );
    }
}
