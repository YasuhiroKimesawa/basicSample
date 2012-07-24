package com.pilgrim_lifestyle.model.eventer.profile;

import lombok.ToString;

@ToString
public class Profile
{
    private PersonName personName;

    public Profile( PersonName personName )
    {
        this.personName = personName;
    }
}
