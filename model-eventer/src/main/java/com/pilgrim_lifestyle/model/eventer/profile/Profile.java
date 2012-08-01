package com.pilgrim_lifestyle.model.eventer.profile;

import javax.validation.Valid;

import lombok.ToString;

@ToString
public class Profile
{
    @Valid
    private PersonName personName;

    public Profile( PersonName personName )
    {
        this.personName = personName;
    }
}
