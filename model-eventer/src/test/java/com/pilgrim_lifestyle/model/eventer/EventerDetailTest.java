package com.pilgrim_lifestyle.model.eventer;

import com.pilgrim_lifestyle.model.eventer.personInfomation.PersonName;
import com.pilgrim_lifestyle.model.eventer.personInfomation.PersonalInfomation;
import com.pilgrim_lifestyle.model.eventer.personInfomation.Profile;
import com.pilgrim_lifestyle.model.eventer.personInfomation.contact.Contact;
import com.pilgrim_lifestyle.model.eventer.personInfomation.contact.MailAddress;
import com.pilgrim_lifestyle.model.eventer.personInfomation.contact.TelephoneNumber;
import com.pilgrim_lifestyle.model.eventer.security.Password;
import com.pilgrim_lifestyle.model.eventer.security.Passwords;
import com.systemsekkei.base.test.model.BaseModelTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith( Enclosed.class )
public class EventerDetailTest
{
    public static class EventerDetailエラー状態 extends BaseModelTest<Eventer>
    {
        Eventer eventer;

        @Before
        public void setup()
        {
            MailAddress mailAddress = new MailAddress( "mail@mail.com" );
            TelephoneNumber telephoneNumber = new TelephoneNumber( "090-1111-2222" );
            Contact contact = new Contact( mailAddress, telephoneNumber );

            PersonName personName = new PersonName( "", "達也" );
            Profile profile = new Profile( personName );

            Password password = new Password( "testtes" );
            Password confirm = new Password( "testtes" );
            Passwords passwords = new Passwords( password, confirm );

            PersonalInfomation personalInfomation = new PersonalInfomation( profile, contact );

            EventerDetail eventerDetail = new EventerDetail( personalInfomation, passwords );

            eventer = new Eventer( 1, eventerDetail );
        }

        @Test
        public void EventerDetailのバリデーションが実行される()
        {
            validateAndAssertCount( 1, eventer );
        }
    }

    public static class notest
    {
        EventerDetail eventerDetail;

        @Before
        public void setup()
        {
            eventerDetail = new EventerDetail();
        }

        @Test
        public void notests()
        {
            EventerDetail.draft();
            eventerDetail.equals( eventerDetail );
            eventerDetail.equals( null );
            eventerDetail.equals( new EventerDetail() );
            eventerDetail.getPasswords();
            eventerDetail.getPersonalInfomation();
            eventerDetail.setPasswords( null );
            eventerDetail.setPersonalInfomation( null );
            eventerDetail.hashCode();
        }
    }

}
