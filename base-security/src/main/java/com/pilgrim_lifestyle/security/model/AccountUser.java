package com.pilgrim_lifestyle.security.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class AccountUser extends User
{

    public AccountUser( String username, String password, Collection<? extends GrantedAuthority> authorities )
    {
        super( username, password, authorities );
        // TODO 自動生成されたコンストラクター・スタブ
    }

    private static final long serialVersionUID = -1192863938113385940L;

}
