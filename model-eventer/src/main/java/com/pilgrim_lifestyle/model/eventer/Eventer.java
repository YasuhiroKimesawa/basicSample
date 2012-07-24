package com.pilgrim_lifestyle.model.eventer;

import com.pilgrim_lifestyle.model.eventer.contact.Contact;
import com.pilgrim_lifestyle.model.eventer.profile.Profile;

import lombok.ToString;

@ToString
public class Eventer
{
    private Profile profile;

    private Contact contact;

	public Eventer( Profile profile, Contact contact )
	{
		this.profile = profile;
		this.contact = contact;
	}
}
