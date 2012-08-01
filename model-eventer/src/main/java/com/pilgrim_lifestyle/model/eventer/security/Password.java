package com.pilgrim_lifestyle.model.eventer.security;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Password
{
    private String password;

    public Password( String password )
    {
        this.password = password;
    }

}
