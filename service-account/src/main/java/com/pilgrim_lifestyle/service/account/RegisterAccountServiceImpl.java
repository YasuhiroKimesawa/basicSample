package com.pilgrim_lifestyle.service.account;

import com.pilgrim_lifestyle.model.account.Account;
import com.pilgrim_lifestyle.model.account.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service( "registerAccountService" )
public class RegisterAccountServiceImpl implements RegisterAccountService
{
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void register( Account account )
    {
        accountRepository.register( account );
    }
}
