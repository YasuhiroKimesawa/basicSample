package com.systemsekkei.base.security.userdetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public abstract class BaseUserDetails implements UserDetails
{
    private Set<GrantedAuthority> authorities;

    protected BaseUserDetails(
            Collection<? extends GrantedAuthority> authorities)
    {
        this.authorities = new HashSet<GrantedAuthority>(authorities);
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities()
    {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }

    private static final long serialVersionUID = 6693382880929489761L;
}
