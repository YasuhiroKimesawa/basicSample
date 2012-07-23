package com.pilgrim_lifestyle.dao.eventer;

import java.io.Serializable;

import lombok.Data;

import com.pilgrim_lifestyle.dao.eventer.contact.Contact;

public @Data class EventerDao implements Serializable
{
    private Contact contact;

    private static final long serialVersionUID = 436655971888812569L;
}
