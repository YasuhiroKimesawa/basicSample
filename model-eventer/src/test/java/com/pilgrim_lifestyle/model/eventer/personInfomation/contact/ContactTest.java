package com.pilgrim_lifestyle.model.eventer.personInfomation.contact;

import org.junit.Test;

import com.pilgrim_lifestyle.model.eventer.personInfomation.contact.Contact;
import com.pilgrim_lifestyle.model.eventer.personInfomation.contact.MailAddress;
import com.pilgrim_lifestyle.model.eventer.personInfomation.contact.TelephoneNumber;
import com.systemsekkei.base.test.model.BaseModelTest;

public class ContactTest extends BaseModelTest<Contact>
{
    @Test
    public void MailAddressのバリデーションが実行される()
    {
        MailAddress mailAddress = new MailAddress( "" );
        TelephoneNumber telephoneNumber = new TelephoneNumber( "090-1111-2222" );
        Contact contact = new Contact( mailAddress, telephoneNumber );
        contact.toString();

        validateAndAssertCount( 1, contact );
    }

    @Test
    public void TelephoneNumberのバリデーションが実行される()
    {
        MailAddress mailAddress = new MailAddress( "abcde@mail.com" );
        TelephoneNumber telephoneNumber = new TelephoneNumber( "" );
        Contact contact = new Contact( mailAddress, telephoneNumber );

        validateAndAssertCount( 1, contact );
    }

    @Test
    public void notest()
    {
        Contact contact = new Contact();
        contact.equals( null );
        contact.equals( contact );
        contact.equals( new Contact() );
        contact.getMailAddress();
        contact.getTelephoneNumber();
        contact.setMailAddress( null );
        contact.setTelephoneNumber( null );
        contact.hashCode();
    }

}
