package com.pilgrim_lifestyle.web.eventer.dao;

import java.io.Serializable;

import lombok.Data;

import com.pilgrim_lifestyle.web.eventer.dao.contact.Contact;
import com.pilgrim_lifestyle.web.eventer.dao.profile.Profile;

public @Data class EventerDao implements Serializable
{
    private Contact contact;

    private Profile profile;

    private static final long serialVersionUID = 436655971888812569L;
}
