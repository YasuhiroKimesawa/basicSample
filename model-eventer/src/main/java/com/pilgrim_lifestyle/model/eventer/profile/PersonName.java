package com.pilgrim_lifestyle.model.eventer.profile;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.ToString;

@ToString
public class PersonName
{
    @NotEmpty( message="姓を入力して下さい。" )
    @Length( max=12, message="姓は12文字以内で入力して下さい" )
    private String lastName;

    @NotEmpty( message="名を入力して下さい。" )
    @Length( max=12, message="名は12文字以内で入力して下さい" )
    private String firstName;

    public PersonName( String lastName, String firstName )
    {
        this.lastName = lastName;
        this.firstName = firstName;
    }

}
