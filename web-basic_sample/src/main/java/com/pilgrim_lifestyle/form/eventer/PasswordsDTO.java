package com.pilgrim_lifestyle.form.eventer;

import lombok.Data;

import java.io.Serializable;

public @Data class PasswordsDTO implements Serializable
{
    private PasswordDTO password;

    private PasswordDTO confirm;

    public PasswordsDTO()
    {
        this.password = new PasswordDTO();
        this.confirm = new PasswordDTO();
    }

    public boolean isConform()
    {
        return true;
    }

    private static final long serialVersionUID = 2553067987698913675L;

}
