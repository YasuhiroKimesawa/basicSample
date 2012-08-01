package com.pilgrim_lifestyle.model.eventer;

import com.pilgrim_lifestyle.model.eventer.contact.Contact;
import com.pilgrim_lifestyle.model.eventer.profile.Profile;

import lombok.ToString;

@ToString
public class Eventer
{
    private Integer id;

    private Profile profile;

    private Contact contact;

	public Eventer( Integer id, Profile profile, Contact contact )
	{
	    this.id = id;
		this.profile = profile;
		this.contact = contact;
	}
}
