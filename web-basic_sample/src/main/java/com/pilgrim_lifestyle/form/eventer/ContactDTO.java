package com.pilgrim_lifestyle.form.eventer;

import lombok.Data;

import java.io.Serializable;

public @Data class ContactDTO implements Serializable
{
    private TelephoneNumberDTO telephoneNumber = new TelephoneNumberDTO();

    private MailAddressDTO mailAddress = new MailAddressDTO();

    private static final long serialVersionUID = 1647513382395277415L;

}
