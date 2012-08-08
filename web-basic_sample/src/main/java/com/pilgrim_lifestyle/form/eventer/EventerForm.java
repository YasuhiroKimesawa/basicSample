package com.pilgrim_lifestyle.form.eventer;

import lombok.Data;

import java.io.Serializable;

public @Data class EventerForm implements Serializable
{
    private ContactDTO contact;

    private ProfileDTO profile;

    private PasswordsDTO passwords;

    public EventerForm()
    {
        this.contact = new ContactDTO();
        this.profile = new ProfileDTO();
        this.passwords = new PasswordsDTO();
    }

    private static final long serialVersionUID = 436655971888812569L;
}
