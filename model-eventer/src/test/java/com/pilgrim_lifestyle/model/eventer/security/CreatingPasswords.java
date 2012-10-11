package com.pilgrim_lifestyle.model.eventer.security;

import java.util.Map;

import com.pilgrim_lifestyle.model.eventer.EventerData;

public class CreatingPasswords
{
    Map<EventerData.Data, String> eventerData;

    public static CreatingPasswords instansOf( Map<EventerData.Data, String> eventerData )
    {
        return new CreatingPasswords( eventerData );
    }

    private CreatingPasswords( Map<EventerData.Data, String> eventerData )
    {
        this.eventerData = eventerData;
    }

    public Passwords createPasswords()
    {
        return new Passwords( createPassword(), createConfirmPassword() );
    }

    public Password createPassword()
    {
        String password = eventerData.get( EventerData.Data.パスワード );
        return new Password( password );
    }

    public Password createConfirmPassword()
    {
        String password = eventerData.get( EventerData.Data.確認パスワード );
        return new Password( password );
    }
}
