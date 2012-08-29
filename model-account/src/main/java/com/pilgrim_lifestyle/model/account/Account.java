package com.pilgrim_lifestyle.model.account;

import com.pilgrim_lifestyle.model.account.Account;

public interface Account
{
    Account create( Integer id );

    String getAuthority();
}
