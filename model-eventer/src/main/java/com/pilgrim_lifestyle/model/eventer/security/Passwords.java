package com.pilgrim_lifestyle.model.eventer.security;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;

import lombok.Data;
import lombok.NoArgsConstructor;

public @Data @NoArgsConstructor class Passwords
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

    public static Passwords draft()
    {
        Password password = new Password( "" );
        Password confirm = new Password( "" );

        return new Passwords( password, confirm );
    }
}
