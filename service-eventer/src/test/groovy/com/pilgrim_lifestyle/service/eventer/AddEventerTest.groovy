package com.pilgrim_lifestyle.service.eventer

import mockit.Deencapsulation;
import mockit.Expectations;
import mockit.Mocked;

import com.pilgrim_lifestyle.model.eventer.Eventer;
import com.pilgrim_lifestyle.model.eventer.EventerRepository;
import com.pilgrim_lifestyle.model.eventer.contact.Contact;
import com.pilgrim_lifestyle.model.eventer.contact.MailAddress;
import com.pilgrim_lifestyle.model.eventer.contact.TelephoneNumber;
import com.pilgrim_lifestyle.model.eventer.profile.PersonName;
import com.pilgrim_lifestyle.model.eventer.profile.Profile;
import com.pilgrim_lifestyle.model.eventer.security.Password;
import com.pilgrim_lifestyle.model.eventer.security.Passwords;

import groovy.transform.TypeChecked
import spock.lang.Specification

import mockit.Deencapsulation;
import mockit.Expectations;
import mockit.Mocked;

class AddEventerTest extends Specification
{
    private Contact contact;
    private Profile profile;
    private Passwords passwords;

    private EventerService eventerService = new EventerService();


    @Mocked( capture = 1 )
    private Eventer eventer;

    @TypeChecked
    def "主催者を登録する"()
    {
        expect:
        PersonName personName = new PersonName( "田中", "達也" );
        TelephoneNumber telephoneNumber = new TelephoneNumber( "080-9999-1111" );
        MailAddress mailAddress = new MailAddress( "mail@mail.com" );
        Password password = new Password( "1111aaaa" );
        Password confirm = new Password( "1111aaaa" );

        profile = new Profile( personName );
        passwords = new Passwords( password, confirm );
        contact = new Contact( mailAddress, telephoneNumber );

        where:

        eventerService.add( contact, profile, passwords );
    }
}
