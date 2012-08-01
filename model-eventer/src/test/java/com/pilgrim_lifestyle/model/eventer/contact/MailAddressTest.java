package com.pilgrim_lifestyle.model.eventer.contact;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.junit.Test;

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
    public void エラーなし()
    {
        MailAddress mailAddress = new MailAddress( "abcde@mail.com" );
        mailAddress.toString();
        validateAndAssertCount( 0, mailAddress );
    }
}
