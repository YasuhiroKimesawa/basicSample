package com.pilgrim_lifestyle.model.account;

import com.pilgrim_lifestyle.model.account.Account;

public interface AccountRepository
{
    Integer nextId();

    void register( Account accountMember );

    boolean isEmailExist( Account account );
}
