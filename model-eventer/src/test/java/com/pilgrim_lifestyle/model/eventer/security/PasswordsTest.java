package com.pilgrim_lifestyle.model.eventer.security;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith( Enclosed.class )
public class PasswordsTest
{
    public static class Password一致
    {
        Passwords passwords;

        @Before
        public void setup()
        {
            Password password = new Password( "testpassword" );
            Password confirm = new Password( "testpassword" );
            passwords = new Passwords( password, confirm );

            // no test
            passwords.toString();
            Passwords.draft();
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
            Password password = new Password( "testpassword" );
            Password confirm = new Password( "falsepassword" );
            passwords = new Passwords( password, confirm );
        }

        @Test
        public void パスワードが一致しない場合はFalseが返ること()
        {
            assertThat( passwords.isMatch(), is( false ) );
        }
    }

    public static class notest
    {
        Passwords passwords;

        @Before
        public void setup()
        {
            passwords = new Passwords();
        }

        @Test
        public void notests()
        {
            passwords.equals( null );
            passwords.equals( passwords );
            passwords.equals( new Passwords() );
            passwords.getConfirm();
            passwords.getPassword();
            passwords.setConfirm( null );
            passwords.setPassword( null );
            passwords.hashCode();
        }
    }

}
