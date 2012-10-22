package com.pilgrim_lifestyle.service.account;

import mockit.Deencapsulation;
import mockit.Expectations;
import mockit.Mocked;

import org.junit.Test;

import com.pilgrim_lifestyle.model.account.AccountRepository;
import com.pilgrim_lifestyle.model.eventer.Eventer;

public class RegisterAccountServiceImplTest
{
    RegisterAccountServiceImpl registerAccountService  = new RegisterAccountServiceImpl();

    Eventer eventer = Eventer.draft( 1 );

    @Mocked
    AccountRepository accountRepository;

    @Test
    public void イベンターを登録する()
    {
        Deencapsulation.setField( registerAccountService, accountRepository );

        new Expectations()
        {{
            accountRepository.register( eventer );
        }};

        registerAccountService.register( eventer );
    }

}
