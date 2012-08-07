package com.pilgrim_lifestyle.table.eventer;

import com.pilgrim_lifestyle.model.eventer.Eventer;
import com.pilgrim_lifestyle.model.eventer.contact.Contact;
import com.pilgrim_lifestyle.model.eventer.contact.MailAddress;
import com.pilgrim_lifestyle.model.eventer.contact.TelephoneNumber;
import com.pilgrim_lifestyle.model.eventer.profile.PersonName;
import com.pilgrim_lifestyle.model.eventer.profile.Profile;
import com.pilgrim_lifestyle.model.eventer.security.Password;
import com.pilgrim_lifestyle.model.eventer.security.Passwords;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

public class EventerTableDxoTest extends EventerTableDxo
{

    @Test
    public void test() throws InvocationTargetException, NoSuchMethodException, Exception
    {
        Profile profile = new Profile( new PersonName( "aa", "bb" ) );
        Contact contact = new Contact( new MailAddress( "aaa" ), new TelephoneNumber( "aa" ) );
        Passwords passwords = new Passwords( new Password( "aa" ), new Password( "aa" ) );
        Eventer eventer = new Eventer( 1, profile, contact, passwords );

        EventerTableDxo eventerTableDxo = new EventerTableDxo();
        eventerTableDxo.toDto( eventer );
    }

}
