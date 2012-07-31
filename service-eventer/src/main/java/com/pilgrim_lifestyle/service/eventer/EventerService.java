package com.pilgrim_lifestyle.service.eventer;

import com.pilgrim_lifestyle.model.eventer.Eventer;
import com.pilgrim_lifestyle.model.eventer.EventerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service( "eventerService" )
public class EventerService
{
    @Autowired
    private EventerRepository eventerRepository;

    public void add( Eventer eventer )
    {
        eventerRepository.add( eventer );
    }
}
