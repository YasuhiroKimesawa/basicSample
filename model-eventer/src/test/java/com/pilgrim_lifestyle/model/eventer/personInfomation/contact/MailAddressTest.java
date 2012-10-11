package com.pilgrim_lifestyle.model.eventer.personInfomation.contact;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.junit.Test;

import com.pilgrim_lifestyle.model.eventer.EventerData;
import com.pilgrim_lifestyle.model.eventer.personInfomation.contact.MailAddress;
import com.systemsekkei.base.test.model.BaseModelTest;

public class MailAddressTest extends BaseModelTest<MailAddress>
{
    @Test
    public void メールアドレスが不正()
    {
        Map<EventerData.Data, String> eventerData = new HashMap<EventerData.Data, String>();
        eventerData.put( EventerData.Data.メールアドレス, "not-mailaddress" );

        MailAddress mailAddress = CreatingContact.instansOf( eventerData ).createMailAddress();

        validateAndAssert( "mailAddress", Email.class, mailAddress );
    }

    @Test
    public void 空は不正()
    {
        Map<EventerData.Data, String> eventerData = new HashMap<EventerData.Data, String>();
        eventerData.put( EventerData.Data.メールアドレス, "" );

        MailAddress mailAddress = CreatingContact.instansOf( eventerData ).createMailAddress();

        validateAndAssert( "mailAddress", NotEmpty.class, mailAddress );
    }

    @Test
    public void 文字50以上は不正()
    {
        Map<EventerData.Data, String> eventerData = new HashMap<EventerData.Data, String>();
        eventerData.put( EventerData.Data.メールアドレス, createMailAddress( 51 ) );

        MailAddress mailAddress = CreatingContact.instansOf( eventerData ).createMailAddress();

        validateAndAssertCount( 2, mailAddress );
    }

    private String createMailAddress( int length )
    {
        StringBuffer mailAddressBuffer = new StringBuffer();

        for( int i = 0; i < length;  i++ )
        {
            mailAddressBuffer.append( "a" );
        }

        assertThat( mailAddressBuffer.length(), is( length ) );

        return mailAddressBuffer.toString();
    }

    @Test
    public void エラーなし()
    {
        Map<EventerData.Data, String> eventerData = new HashMap<EventerData.Data, String>();
        eventerData.put( EventerData.Data.メールアドレス, "abcde@mail.com" );

        MailAddress mailAddress = CreatingContact.instansOf( eventerData ).createMailAddress();

        validateAndAssertCount( 0, mailAddress );
    }
}
