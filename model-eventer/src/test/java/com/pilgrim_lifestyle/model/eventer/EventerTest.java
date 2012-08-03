package com.pilgrim_lifestyle.model.eventer;

import org.junit.Before;
import org.junit.Test;

import com.pilgrim_lifestyle.model.eventer.contact.Contact;
import com.pilgrim_lifestyle.model.eventer.contact.MailAddress;
import com.pilgrim_lifestyle.model.eventer.contact.TelephoneNumber;
import com.pilgrim_lifestyle.model.eventer.profile.PersonName;
import com.pilgrim_lifestyle.model.eventer.profile.Profile;
import com.pilgrim_lifestyle.model.eventer.security.Password;
import com.pilgrim_lifestyle.model.eventer.security.Passwords;
import com.systemsekkei.base.test.model.BaseModelTest;

public class EventerTest extends BaseModelTest<Eventer>
{
    Eventer eventer;

    Contact contact;
    Profile profile;
    Passwords passwords;

    @Before
    public void setup()
    {
        MailAddress mailAddress = new MailAddress( "mail@mail.com" );
        TelephoneNumber telephoneNumber = new TelephoneNumber( "090-1111-2222" );
        contact = new Contact( mailAddress, telephoneNumber );

        PersonName personName = new PersonName( "田中", "達也" );
        profile = new Profile( personName );

        Password password = new Password( "testpassword" );
        Password confirm = new Password( "testpassword" );
        passwords = new Passwords( password, confirm );

        eventer = new Eventer( 1, profile, contact, passwords );
        eventer.toString();
    }

    @Test
    public void Profileのバリデーションが実行される()
    {
        PersonName personName = new PersonName( "", "達也" );
        profile = new Profile( personName );

        eventer = new Eventer( 1, profile, contact, passwords );

        validateAndAssertCount( 1, eventer );
    }

    @Test
    public void Contactのバリデーションが実行される()
    {
        MailAddress mailAddress = new MailAddress( "" );
        TelephoneNumber telephoneNumber = new TelephoneNumber( "090-1111-2222" );
        contact = new Contact( mailAddress, telephoneNumber );

        eventer = new Eventer( 1, profile, contact, passwords );

        validateAndAssertCount( 1, eventer );
    }

    @Test
    public void Passwordsのバリデーションが実行される()
    {
        Password password = new Password( "test" );
        Password confirm = new Password( "testaa" );
        passwords = new Passwords( password, confirm );

        eventer = new Eventer( 1, profile, contact, passwords );

        validateAndAssertCount( 1, eventer );
    }

}
