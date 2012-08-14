package com.pilgrim_lifestyle.model.eventer.security;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;

import lombok.ToString;

@ToString
public class Passwords
{
    @Valid
    private Password password;

    private Password confirm;

    public Passwords( Password password, Password confirm )
    {
        this.password = password;
        this.confirm = confirm;
    }

    @AssertTrue( message = "パスワードが一致しません。" )
    public Boolean isConform()
    {
        return password.equals( confirm );
    }
}
