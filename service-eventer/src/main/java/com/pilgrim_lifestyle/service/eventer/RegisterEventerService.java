package com.pilgrim_lifestyle.service.eventer;

import com.pilgrim_lifestyle.model.eventer.Eventer;
import com.pilgrim_lifestyle.model.eventer.EventerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service( "registerEventerService" )
public class RegisterEventerService
{
    @Autowired
    private EventerRepository eventerRepository;

    public void register( Eventer eventer )
    {
        Integer id = eventerRepository.nextId();

        Eventer registerEventer = new Eventer( id, eventer.getEventerDetail() );

        add( registerEventer );
    }

    private void add( Eventer eventer )
    {
        eventerRepository.add( eventer );
    }
}
