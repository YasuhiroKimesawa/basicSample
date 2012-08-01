package com.pilgrim_lifestyle.form.eventer;

import java.io.Serializable;

import lombok.Data;

public @Data class ContactDTO implements Serializable
{

    private String telephoneNumber;

    private String mailAddress;

    private static final long serialVersionUID = 1647513382395277415L;

}
