package com.pilgrim_lifestyle.model.eventer;

import com.pilgrim_lifestyle.model.eventer.contact.Contact;
import com.pilgrim_lifestyle.model.eventer.profile.Profile;
import com.pilgrim_lifestyle.model.eventer.security.Passwords;

import javax.validation.Valid;

import lombok.ToString;

@ToString
public class Eventer
{
    private Integer id;

    @Valid
    private Profile profile;

    @Valid
    private Contact contact;

    @Valid
    private Passwords passwords;

	public Eventer( Integer id, Profile profile, Contact contact, Passwords passwords )
	{
	    this.id = id;
		this.profile = profile;
		this.contact = contact;
		this.passwords = passwords;
	}

}
