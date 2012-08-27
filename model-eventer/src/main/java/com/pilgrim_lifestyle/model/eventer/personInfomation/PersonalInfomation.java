package com.pilgrim_lifestyle.model.eventer.personInfomation;

import javax.validation.Valid;

import lombok.Data;
import lombok.NoArgsConstructor;

import com.pilgrim_lifestyle.model.eventer.personInfomation.contact.Contact;

public @Data @NoArgsConstructor class PersonalInfomation
{
    @Valid
    private Profile profile;

    @Valid
    private Contact contact;

    public PersonalInfomation( Profile profile, Contact contact )
    {
        this.profile = profile;

        this.contact = contact;
    }

    public static PersonalInfomation draft()
    {
        Profile profile = Profile.draft();

        Contact contact = Contact.draft();

        return new PersonalInfomation( profile, contact );
    }

}
