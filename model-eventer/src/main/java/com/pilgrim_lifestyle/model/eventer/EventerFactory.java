package com.pilgrim_lifestyle.model.eventer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pilgrim_lifestyle.model.account.AccountRepository;

@Component( "eventerFactory" )
public class EventerFactory
{
    @Autowired
    private AccountRepository acoounRepository;

    private Integer number()
    {
        return acoounRepository.nextId();
    }

    public Eventer createDraft()
    {
        Integer id = number();

        return Eventer.draft( id );
    }
}
