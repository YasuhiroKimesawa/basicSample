package com.pilgrim_lifestyle.form.eventer;

import com.pilgrim_lifestyle.web.tool.Trim;

import lombok.Data;

import java.io.Serializable;

public @Data class ProfileDTO implements Serializable
{

    private String lastName;

    private String firstName;

    public String getLastName()
    {
        return Trim.trim( lastName );
    }

    public String getFirstName()
    {
        return Trim.trim( firstName );
    }

    private static final long serialVersionUID = -7824510476829185831L;

}
