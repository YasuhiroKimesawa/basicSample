package com.pilgrim_lifestyle.service.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pilgrim_lifestyle.model.event.Event;
import com.pilgrim_lifestyle.model.event.EventRepository;

@Service( "registerEventService" )
public class RegisterEventServiceImpl implements RegisterEventService
{
    @Autowired
    private EventRepository eventerRepository;

    @Override
    public void register( Event event )
    {
        Integer id = eventerRepository.nextId();

        Event newEvent = new Event( id, event.getName(), event.getEventDetail() );

        eventerRepository.register( newEvent );

    }

}