package com.pilgrim_lifestyle.security.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class AccountUser extends User
{
    private String lastName;

    public AccountUser( String mailaddress, String password, String lastName, Collection<? extends GrantedAuthority> authorities )
    {
        super( mailaddress, password, authorities );

        this.lastName = lastName;
    }

    public String getLastName()
    {
        return lastName;
    }

    private static final long serialVersionUID = -1192863938113385940L;

}
