package com.pilgrim_lifestyle.model.eventer.personInfomation;

import javax.validation.Valid;

import lombok.Data;
import lombok.NoArgsConstructor;

public @Data @NoArgsConstructor class Profile
{
    @Valid
    private PersonName personName;

    public Profile( PersonName personName )
    {
        this.personName = personName;
    }

    public static Profile draft()
    {
        PersonName personName = new PersonName( "", "" );

        return new Profile( personName );
    }

}
