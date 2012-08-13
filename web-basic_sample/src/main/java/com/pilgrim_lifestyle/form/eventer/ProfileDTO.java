package com.pilgrim_lifestyle.form.eventer;

import lombok.Data;

import java.io.Serializable;

public @Data class ProfileDTO implements Serializable
{
    private PersonNameDTO personName;

    public ProfileDTO()
    {
        personName = new PersonNameDTO();
    }

    private static final long serialVersionUID = -7824510476829185831L;

}
