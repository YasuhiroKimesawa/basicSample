package com.pilgrim_lifestyle.model.eventer;

import java.util.Map;

import com.pilgrim_lifestyle.model.eventer.personInfomation.CreatingPersonalInfomation;
import com.pilgrim_lifestyle.model.eventer.personInfomation.PersonalInfomation;
import com.pilgrim_lifestyle.model.eventer.security.CreatingPasswords;
import com.pilgrim_lifestyle.model.eventer.security.Passwords;

public class CreateEventer
{
    Map<EventerData.Data, String> eventerData;

    public static CreateEventer instansOf( Map<EventerData.Data, String> eventerData )
    {
        return new CreateEventer( eventerData );
    }

    private CreateEventer( Map<EventerData.Data, String> eventerData )
    {
        this.eventerData = eventerData;
    }

    public Eventer createEventer()
    {
        String id = eventerData.get( EventerData.Data.ID );

        return new Eventer( Integer.valueOf( id ), createEventerDetail() );
    }

    public EventerDetail createEventerDetail()
    {
        PersonalInfomation personalInfomation = CreatingPersonalInfomation.instansOf( eventerData ).createPersonalInfomation();
        Passwords passwords = CreatingPasswords.instansOf( eventerData ).createPasswords();

        return new EventerDetail( personalInfomation, passwords );
    }
}
