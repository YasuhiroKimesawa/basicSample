package com.pilgrim_lifestyle.model.eventer.profile;

import lombok.ToString;

@ToString
public class PersonName
{

    private String lastName;

    private String firstName;

    public PersonName( String lastName, String firstName )
    {
        this.lastName = lastName;
        this.firstName = firstName;
    }

}
