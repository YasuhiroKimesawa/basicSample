package com.pilgrim_lifestyle.model.eventer.contact;

import java.io.Serializable;

import lombok.ToString;

@ToString
public class Contact implements Serializable
{
    private MailAddress mailAddress;

    private TelephoneNumber telephoneNumber;

    private static final long serialVersionUID = 4104351102259716768L;

}
