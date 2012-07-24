package com.pilgrim_lifestyle.form.eventer;

import lombok.Data;

import java.io.Serializable;

public @Data class EventerForm implements Serializable
{
    private String lastName;

    private String firstName;

    private String mailAddress;

    private String telophoneNumber;

    private static final long serialVersionUID = 436655971888812569L;
}
