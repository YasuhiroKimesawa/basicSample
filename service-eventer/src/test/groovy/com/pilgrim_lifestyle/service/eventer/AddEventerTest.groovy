package com.pilgrim_lifestyle.service.eventer

import com.pilgrim_lifestyle.model.eventer.Eventer;
import com.pilgrim_lifestyle.model.eventer.EventerRepository;
import com.pilgrim_lifestyle.model.eventer.contact.Contact;
import com.pilgrim_lifestyle.model.eventer.contact.MailAddress;
import com.pilgrim_lifestyle.model.eventer.contact.TelephoneNumber;
import com.pilgrim_lifestyle.model.eventer.profile.PersonName;
import com.pilgrim_lifestyle.model.eventer.profile.Profile;
import com.pilgrim_lifestyle.model.eventer.security.Password;
import com.pilgrim_lifestyle.model.eventer.security.Passwords;

import mockit.Deencapsulation;
import mockit.Expectations;
import mockit.Mocked;

import spock.lang.*

class AddEventerTest extends Specification
{
    def eventerService = new EventerService()

    @Mocked
    EventerRepository eventerRepository

    @Mocked( capture = 1 )
    Eventer eventer

    def personName = new PersonName( "田中", "達也" )
    def telephoneNumber = new TelephoneNumber( "080-9999-1111" )
    def mailAddress = new MailAddress( "mail@mail.com" )
    def password = new Password( "1111aaaa" )
    def confirm = new Password( "1111aaaa" )

    def "主催者を登録する"()
    {
        setup:
        def profile = new Profile( personName );
        def passwords = new Passwords( password, confirm );
        def contact = new Contact( mailAddress, telephoneNumber );

        when:
        Deencapsulation.setField( eventerService, eventerRepository );

        then:
        eventerService.add( eventer )

    }
}
