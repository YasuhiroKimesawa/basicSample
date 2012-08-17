package com.systemsekkei.base.security.web.login;

public class LoginForm implements java.io.Serializable
{
    private String username;

    private String password;

    private boolean loginFrailed = false;

    public LoginForm(String username, String password)
    {
        this(username, password, true);
    }

    public LoginForm()
    {
    }

    public LoginForm(String username, String password, boolean loginFailed)
    {
        this.username = emptyToNull(username);
        this.password = emptyToNull(password);
        this.loginFrailed = loginFailed;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public boolean isLoginFailed()
    {
        return loginFrailed;
    }

    public boolean isUsernameEmpty()
    {
        return username == null;
    }

    public boolean isPasswordEmpty()
    {
        return password == null;
    }

    public boolean isAllEntered()
    {
        return !isUsernameEmpty() && !isPasswordEmpty();
    }

    private static String emptyToNull(String value)
    {
        if (value == null || value.length() == 0)
        {
            return null;
        }

        return value;
    }

    private static final long serialVersionUID = 6258236699001157304L;
}
