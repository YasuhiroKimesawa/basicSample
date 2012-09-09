package com.pilgrim_lifestyle.model.eventer;

import com.pilgrim_lifestyle.model.eventer.personInfomation.PersonNameTest;
import com.pilgrim_lifestyle.model.eventer.personInfomation.PersonalInfomationTest;
import com.pilgrim_lifestyle.model.eventer.personInfomation.ProfileTest;
import com.pilgrim_lifestyle.model.eventer.personInfomation.contact.ContactTest;
import com.pilgrim_lifestyle.model.eventer.personInfomation.contact.MailAddressTest;
import com.pilgrim_lifestyle.model.eventer.personInfomation.contact.TelephoneNumberTest;
import com.pilgrim_lifestyle.model.eventer.security.PasswordTest;
import com.pilgrim_lifestyle.model.eventer.security.PasswordsTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith( value = Suite.class )
@SuiteClasses( value = {
        EventerTest.class,
        EventerDetailTest.class,
        PersonalInfomationTest.class,
        PersonNameTest.class,
        ProfileTest.class,
        ContactTest.class,
        MailAddressTest.class,
        TelephoneNumberTest.class,
        PasswordsTest.class,
        PasswordTest.class,

})
public class AllTest
{

}
