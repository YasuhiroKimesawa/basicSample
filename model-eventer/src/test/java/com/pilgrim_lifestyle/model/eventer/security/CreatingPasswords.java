package com.pilgrim_lifestyle.model.eventer.security;

import java.util.Map;

import com.pilgrim_lifestyle.model.eventer.EventerData;

public class CreatingPasswords
{
    public static Passwords createPasswords( Map<EventerData.Data, String> eventerData )
    {
        return new Passwords( createPassword( eventerData ), createConfirmPassword( eventerData ) );
    }

    public static Password createPassword( Map<EventerData.Data, String> eventerData )
    {
        String password = eventerData.get( EventerData.Data.パスワード );
        return new Password( password );
    }

    public static Password createConfirmPassword( Map<EventerData.Data, String> eventerData )
    {
        String password = eventerData.get( EventerData.Data.確認パスワード );
        return new Password( password );
    }
}
