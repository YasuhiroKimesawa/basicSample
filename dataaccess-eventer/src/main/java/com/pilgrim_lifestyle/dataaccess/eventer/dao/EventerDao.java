package com.pilgrim_lifestyle.dataaccess.eventer.dao;

import com.pilgrim_lifestyle.dataaccess.eventer.dao.contact.Contact;
import com.pilgrim_lifestyle.dataaccess.eventer.dao.profile.Profile;

import lombok.Data;

public @Data class EventerDao
{
    private Contact contact;

    private Profile profile;
}
