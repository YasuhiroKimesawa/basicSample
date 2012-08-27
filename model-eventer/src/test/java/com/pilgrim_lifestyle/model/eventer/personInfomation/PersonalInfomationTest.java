package com.pilgrim_lifestyle.model.eventer.personInfomation;

import com.pilgrim_lifestyle.model.eventer.personInfomation.contact.Contact;
import com.pilgrim_lifestyle.model.eventer.personInfomation.contact.MailAddress;
import com.pilgrim_lifestyle.model.eventer.personInfomation.contact.TelephoneNumber;
import com.systemsekkei.base.test.model.BaseModelTest;

import org.junit.Before;
import org.junit.Test;

public class PersonalInfomationTest
{

    public static class PersonalInfomationエラー状態 extends BaseModelTest<PersonalInfomation>
    {
        PersonalInfomation personalInfomation;

        @Before
        public void setup()
        {
            MailAddress mailAddress = new MailAddress( "mail@mail.com" );
            TelephoneNumber telephoneNumber = new TelephoneNumber( "090-1111-2222" );
            Contact contact = new Contact( mailAddress, telephoneNumber );

            PersonName personName = new PersonName( "", "達也" );
            Profile profile = new Profile( personName );

            personalInfomation = new PersonalInfomation( profile, contact );
        }

        @Test
        public void EventerDetailのバリデーションが実行される()
        {
            validateAndAssertCount( 1, personalInfomation );
        }
    }

}
