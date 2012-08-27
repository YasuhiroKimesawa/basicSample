package com.pilgrim_lifestyle.model.eventer.personInfomation.contact;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.junit.Test;

import com.pilgrim_lifestyle.model.eventer.personInfomation.contact.MailAddress;
import com.systemsekkei.base.test.model.BaseModelTest;

public class MailAddressTest extends BaseModelTest<MailAddress>
{
    @Test
    public void メールアドレスが不正()
    {
        MailAddress mailAddress = new MailAddress( "not-mailaddress" );
        validateAndAssert( "mailAddress", Email.class, mailAddress );
    }

    @Test
    public void 空は不正()
    {
        MailAddress mailAddress = new MailAddress( "" );
        validateAndAssert( "mailAddress", NotEmpty.class, mailAddress );
    }

    @Test
    public void 文字90以上は不正()
    {
        StringBuffer mailAddressBuffer = new StringBuffer();
        int maxLength = 51;

        for( int i = 0; i < maxLength;  i++ )
        {
            mailAddressBuffer.append( "a" );
        }

        MailAddress mailAddress = new MailAddress( mailAddressBuffer.toString() );

        assertThat( mailAddressBuffer.length(), is( 51 ) );
        validateAndAssertCount( 2, mailAddress );
    }

    @Test
    public void エラーなし()
    {
        MailAddress mailAddress = new MailAddress( "abcde@mail.com" );
        mailAddress.toString();
        validateAndAssertCount( 0, mailAddress );
    }
}
