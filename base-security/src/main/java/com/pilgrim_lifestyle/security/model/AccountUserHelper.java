package com.pilgrim_lifestyle.security.model;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class AccountUserHelper
{
    public static AccountUser getLoginUser()
    {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();

        if (authentication == null)
        {
            return null;
        }

        return ( AccountUser ) authentication.getPrincipal();
    }
}
