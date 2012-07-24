package com.pilgrim_lifestyle.dao.eventer;

import java.io.Serializable;

import lombok.Data;

import com.pilgrim_lifestyle.dao.eventer.contact.Contact;
import com.pilgrim_lifestyle.dao.eventer.profile.Profile;

public @Data class EventerDao implements Serializable
{
    private Contact contact;

    private Profile profile;

    private static final long serialVersionUID = 436655971888812569L;
}
