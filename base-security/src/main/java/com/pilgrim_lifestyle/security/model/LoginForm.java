package com.pilgrim_lifestyle.security.model;

public class LoginForm
{
    private String loginEmailAddress;

    private String password;

    private boolean loginFrailed = false;

    public LoginForm( String loginEmailAddress, String password )
    {
        this( loginEmailAddress, password, true );
    }

    public LoginForm()
    {
    }

    public LoginForm(String loginEmailAddress, String password, boolean loginFailed)
    {
        this.loginEmailAddress = emptyToNull( loginEmailAddress );
        this.password = emptyToNull(password);
        this.loginFrailed = loginFailed;
    }

    public String getLoginEmailAddress()
    {
        return loginEmailAddress;
    }

    public String getPassword()
    {
        return password;
    }

    public boolean isLoginFailed()
    {
        return loginFrailed;
    }

    public boolean isLoginEmailAddressEmpty()
    {
        return loginEmailAddress == null;
    }

    public boolean isPasswordEmpty()
    {
        return password == null;
    }

    public boolean isAllEntered()
    {
        return !isLoginEmailAddressEmpty() && !isPasswordEmpty();
    }

    private static String emptyToNull(String value)
    {
        if ( value == null || value.length() == 0 )
        {
            return null;
        }

        return value;
    }
}
