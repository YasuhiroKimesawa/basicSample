package com.pilgrim_lifestyle.form.eventer;

import com.pilgrim_lifestyle.web.tool.Trim;

import lombok.Data;

import java.io.Serializable;


public @Data class ContactDTO implements Serializable
{

    private String telephoneNumber;

    private String mailAddress;

    public String getTelephoneNumber()
    {
        return Trim.trim( telephoneNumber );
    }

    public String getMailAddress()
    {
        return Trim.trim( mailAddress );
    }

    private static final long serialVersionUID = 1647513382395277415L;

}
