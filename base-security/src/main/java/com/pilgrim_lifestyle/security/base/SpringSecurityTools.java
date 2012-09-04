package com.pilgrim_lifestyle.security.base;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.velocity.tools.config.DefaultKey;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

@DefaultKey("auth")
public class SpringSecurityTools
{
    private static final String ROLE_ANONYMOUS = "ROLE_ANONYMOUS";
    private static final String ROLE_ADMIN = "ROLE_ADMIN";

    public Authentication getAuthentication()
    {
        SecurityContext context = SecurityContextHolder.getContext();
        if (context == null)
        {
            return null;
        }
        return context.getAuthentication();
    }

    public Object getUser()
    {
        Authentication authentication = getAuthentication();
        if (authentication == null)
        {
            return null;
        }
        return authentication.getPrincipal();
    }

    public boolean isGranted(String definedRole)
    {
        return isAnyGranted( definedRole );
    }

    public boolean isAllGranted(String... definedRole)
    {
        Set<String> roleSet = getRoleNameSet();
        roleSet.retainAll(asCollection(definedRole));

        return roleSet.isEmpty();
    }

    public boolean isAnyGranted(String... definedRoles) {
        return !isNotGranted(definedRoles);
    }

    public boolean isNotGranted(String... definedRoles) {
        Set<String> roleSet = getRoleNameSet();
        roleSet.retainAll(asCollection(definedRoles));

        return roleSet.isEmpty();
    }

    public boolean isAnonymous()
    {
        return isGranted(ROLE_ANONYMOUS);
    }

    public boolean isAdmin()
    {
        return isGranted(ROLE_ADMIN);
    }

    private Set<String> getRoleNameSet() {
        Authentication authentication = getAuthentication();
        @SuppressWarnings( "unchecked" )
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) authentication.getAuthorities();

        Set<String> roleNameSet = new HashSet<String>();
        for (GrantedAuthority authority : authorities)
        {
            roleNameSet.add( authority.getAuthority() );
        }
        return roleNameSet;
    }

    private Collection<String> asCollection(String[] strings) {
        return Arrays.asList( strings );
    }


}
