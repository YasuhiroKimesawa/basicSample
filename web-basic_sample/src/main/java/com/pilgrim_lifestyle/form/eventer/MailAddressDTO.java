package com.pilgrim_lifestyle.form.eventer;

import com.pilgrim_lifestyle.web.tool.Trim;

import lombok.Data;

import java.io.Serializable;

public @Data class MailAddressDTO implements Serializable
{
    private String mailAddress = "";

    public String getMailAddress()
    {
        return Trim.trim( mailAddress );
    }

    private static final long serialVersionUID = -8582695305161478938L;

}
