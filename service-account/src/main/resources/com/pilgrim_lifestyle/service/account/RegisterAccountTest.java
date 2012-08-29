package com.pilgrim_lifestyle.service.account;

import com.pilgrim_lifestyle.model.account.AccountRepository;
import com.pilgrim_lifestyle.model.eventer.Eventer;
import com.pilgrim_lifestyle.model.eventer.EventerDetail;
import com.pilgrim_lifestyle.model.eventer.personInfomation.PersonName;
import com.pilgrim_lifestyle.model.eventer.personInfomation.PersonalInfomation;
import com.pilgrim_lifestyle.model.eventer.personInfomation.Profile;
import com.pilgrim_lifestyle.model.eventer.personInfomation.contact.Contact;
import com.pilgrim_lifestyle.model.eventer.personInfomation.contact.MailAddress;
import com.pilgrim_lifestyle.model.eventer.personInfomation.contact.TelephoneNumber;
import com.pilgrim_lifestyle.model.eventer.security.Password;
import com.pilgrim_lifestyle.model.eventer.security.Passwords;

import mockit.Mocked;
import mockit.NonStrictExpectations;
import mockit.Verifications;

import org.junit.Before;
import org.junit.Test;

public class RegisterAccountTest
{
    private RegisterAccountService accountService = new RegisterAccountServiceImpl();

    @Mocked
    private AccountRepository accountRepository;

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

        Profile profile = new Profile( personName );
        Passwords passwords = new Passwords( password, confirm );
        Contact contact = new Contact( mailAddress, telephoneNumber );

        PersonalInfomation personalInfomation = new PersonalInfomation( profile, contact );
        EventerDetail eventerDetail = new EventerDetail( personalInfomation, passwords );

        eventer = new Eventer( 0, eventerDetail );
    }

    @Test
    public void 晴れの日_主催者を追加する()
    {
        new NonStrictExpectations()
        {{
            setField( accountService, accountRepository );
            accountRepository.nextId(); result = 1;

            accountRepository.add( eventer );
        }};

        accountService.register( eventer );

        new Verifications()
        {
            {
                accountRepository.nextId();

                accountRepository.add( eventer );
            }

        };
    }
}
