package com.pilgrim_lifestyle.model.eventer.personInfomation;

import java.util.Map;

import com.pilgrim_lifestyle.model.eventer.EventerData;
import com.pilgrim_lifestyle.model.eventer.personInfomation.contact.Contact;
import com.pilgrim_lifestyle.model.eventer.personInfomation.contact.CreatingContact;

public class CreatingPersonalInfomation
{
    Map<EventerData, String> eventerData;

    public static CreatingPersonalInfomation instansOf( Map<EventerData, String> eventerData )
    {
        return new CreatingPersonalInfomation( eventerData );
    }

    private CreatingPersonalInfomation( Map<EventerData, String> eventerData )
    {
        this.eventerData = eventerData;
    }

    public PersonalInfomation createPersonalInfomation()
    {
        Contact contact = CreatingContact.instansOf( eventerData ).createContact();

        return new PersonalInfomation( createProfile(), contact );
    }

    public Profile createProfile()
    {
        return new Profile( createPersonName() );
    }

    public PersonName createPersonName()
    {
        return new PersonName( eventerData.get( EventerData.姓 ), eventerData.get( EventerData.名 ) );
    }
}
