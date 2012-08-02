package com.pilgrim_lifestyle.model.eventer;

import com.pilgrim_lifestyle.model.eventer.contact.ContactTest;
import com.pilgrim_lifestyle.model.eventer.contact.MailAddressTest;
import com.pilgrim_lifestyle.model.eventer.contact.TelephoneNumberTest;
import com.pilgrim_lifestyle.model.eventer.profile.PersonNameTest;
import com.pilgrim_lifestyle.model.eventer.profile.ProfileTest;
import com.pilgrim_lifestyle.model.eventer.security.PasswordTest;
import com.pilgrim_lifestyle.model.eventer.security.PasswordsTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith( value = Suite.class )
@SuiteClasses( value = {
        EventerTest.class,
        ContactTest.class,
        MailAddressTest.class,
        TelephoneNumberTest.class,
        PersonNameTest.class,
        ProfileTest.class,
        PasswordsTest.class,
        PasswordTest.class
})
public class AllTest
{

}
