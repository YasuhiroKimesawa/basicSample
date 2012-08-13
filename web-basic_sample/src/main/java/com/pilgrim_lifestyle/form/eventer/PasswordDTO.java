package com.pilgrim_lifestyle.form.eventer;

import lombok.Data;

import java.io.Serializable;

public @Data class PasswordDTO implements Serializable
{
    private String password = "";

    private static final long serialVersionUID = 2006858193737266592L;

}
