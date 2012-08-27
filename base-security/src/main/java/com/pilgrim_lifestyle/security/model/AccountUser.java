package com.pilgrim_lifestyle.security.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class AccountUser extends User
{
    private String fullName;

    public AccountUser( String mailaddress, String password, String fullName, Collection<? extends GrantedAuthority> authorities )
    {
        super( mailaddress, password, authorities );

        this.fullName = fullName;
    }

    public String getFullName()
    {
        return fullName;
    }

    private static final long serialVersionUID = -1192863938113385940L;

}
