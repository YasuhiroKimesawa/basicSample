package com.pilgrim_lifestyle.form.eventer;

import java.io.Serializable;

import lombok.Data;

public @Data class PasswordsDTO implements Serializable
{

    private String password;

    private String confirm;

    private static final long serialVersionUID = 2553067987698913675L;

}