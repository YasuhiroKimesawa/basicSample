package com.pilgrim_lifestyle.model.eventer;

import java.util.Map;

import com.pilgrim_lifestyle.model.eventer.personInfomation.CreatingPersonalInfomation;
import com.pilgrim_lifestyle.model.eventer.personInfomation.PersonalInfomation;
import com.pilgrim_lifestyle.model.eventer.security.CreatingPasswords;
import com.pilgrim_lifestyle.model.eventer.security.Passwords;

public class CreateEventer
{
    public static Eventer createEventer( Map<EventerData.Data, String> eventerData )
    {
        String id = eventerData.get( EventerData.Data.ID );

        return new Eventer( Integer.valueOf( id ), createEventerDetail( eventerData ) );
    }

    public static EventerDetail createEventerDetail( Map<EventerData.Data, String> eventerData )
    {
        PersonalInfomation personalInfomation = CreatingPersonalInfomation.createPersonalInfomation( eventerData );
        Passwords passwords = CreatingPasswords.createPasswords( eventerData );

        return new EventerDetail( personalInfomation, passwords );
    }
}
