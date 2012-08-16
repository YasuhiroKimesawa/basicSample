package com.pilgrim_lifestyle.service.eventer;

import com.pilgrim_lifestyle.model.eventer.Eventer;
import com.pilgrim_lifestyle.model.eventer.EventerRepository;
import com.pilgrim_lifestyle.model.eventer.contact.Contact;
import com.pilgrim_lifestyle.model.eventer.contact.MailAddress;
import com.pilgrim_lifestyle.model.eventer.contact.TelephoneNumber;
import com.pilgrim_lifestyle.model.eventer.profile.PersonName;
import com.pilgrim_lifestyle.model.eventer.profile.Profile;
import com.pilgrim_lifestyle.model.eventer.security.Password;
import com.pilgrim_lifestyle.model.eventer.security.Passwords;
import com.pilgrim_lifestyle.service.eventer.EventerService;

import mockit.Mocked;
import mockit.NonStrictExpectations;
import mockit.Verifications;

import org.junit.Before;
import org.junit.Test;

public class AddEventerTest
{
    private Contact contact;
    private Profile profile;
    private Passwords passwords;

    private EventerService eventerService = new EventerService();

    @Mocked
    private EventerRepository eventerRepository;

    @Mocked(capture = 1)
    private Eventer eventer;

    @Before
    public void setup()
    {
        PersonName personName = new PersonName( "田中", "達也" );
        TelephoneNumber telephoneNumber = new TelephoneNumber( "080-9999-1111" );
        MailAddress mailAddress = new MailAddress( "mail@mail.com" );
        Password password = new Password( "1111aaaa" );
        Password confirm = new Password( "1111aaaa" );

        profile = new Profile( personName );
        passwords = new Passwords( password, confirm );
        contact = new Contact( mailAddress, telephoneNumber );
    }

    @Test
    public void 晴れの日_主催者を追加する()
    {
        new NonStrictExpectations()
        {{
            setField( eventerService, eventerRepository );
            eventerRepository.nextId(); result = 1;

            eventerRepository.add( eventer );

        }};

        eventerService.add( contact, profile, passwords );

        new Verifications()
        {
            {
                eventerRepository.nextId();

                eventerRepository.add( eventer );

            }

        };
    }
}
