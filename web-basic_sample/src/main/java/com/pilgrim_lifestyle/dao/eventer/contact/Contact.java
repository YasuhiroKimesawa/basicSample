package com.pilgrim_lifestyle.dao.eventer.contact;

import java.io.Serializable;

import lombok.Data;

public @Data class Contact implements Serializable
{
    private MailAddress mailAddress;

    private TelephoneNumber telephoneNumber;

    private static final long serialVersionUID = 7458452036962653598L;
}
