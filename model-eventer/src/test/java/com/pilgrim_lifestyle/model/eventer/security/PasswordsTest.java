package com.pilgrim_lifestyle.model.eventer.security;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import com.pilgrim_lifestyle.model.eventer.EventerData;

@RunWith( Enclosed.class )
public class PasswordsTest
{
    public static class Password一致
    {
        Passwords passwords;

        @Before
        public void setup()
        {
            Map<EventerData, String> eventerData = new HashMap<EventerData, String>();
            eventerData.put( EventerData.パスワード, "testpassword" );
            eventerData.put( EventerData.確認パスワード, "testpassword" );

            passwords = CreatingPasswords.instansOf( eventerData ).createPasswords();
        }

        @Test
        public void パスワードが一致する場合はTrueが返ること()
        {
            assertThat( passwords.isMatch(), is( true ) );
        }
    }

    public static class Password不一致
    {
        Passwords passwords;

        @Before
        public void setup()
        {
            Map<EventerData, String> eventerData = new HashMap<EventerData, String>();
            eventerData.put( EventerData.パスワード, "testpassword" );
            eventerData.put( EventerData.確認パスワード, "falsepassword" );

            passwords = CreatingPasswords.instansOf( eventerData ).createPasswords();
        }

        @Test
        public void パスワードが一致しない場合はFalseが返ること()
        {
            assertThat( passwords.isMatch(), is( false ) );
        }
    }
}
