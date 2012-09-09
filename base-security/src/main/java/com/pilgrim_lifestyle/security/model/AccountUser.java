package com.pilgrim_lifestyle.security.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class AccountUser extends User
{
    private Integer id;

    private String fullName;

    public AccountUser( Integer id, String mailaddress, String password, String fullName, Collection<? extends GrantedAuthority> authorities )
    {
        super( mailaddress, password, authorities );

        this.id = id;

        this.fullName = fullName;
    }

    public Integer getId()
    {
        return id;
    }

    public String getFullName()
    {
        return fullName;
    }

    private static final long serialVersionUID = -1192863938113385940L;

}
