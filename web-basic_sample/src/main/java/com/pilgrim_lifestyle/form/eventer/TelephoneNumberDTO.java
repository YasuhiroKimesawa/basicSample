package com.pilgrim_lifestyle.form.eventer;

import lombok.Data;

import com.pilgrim_lifestyle.web.tool.Trim;

import java.io.Serializable;

public @Data class TelephoneNumberDTO implements Serializable
{
    private String number = "";

    public String getNumber()
    {
        return Trim.trim( number );
    }

    private static final long serialVersionUID = -6231874799395975974L;

}
