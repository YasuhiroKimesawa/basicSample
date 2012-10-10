package com.pilgrim_lifestyle.model.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component( "eventFactory" )
public class EventFactory
{
    @Autowired
    private EventRepository eventRepository;

    private Integer number()
    {
        return eventRepository.nextId();
    }

    public Event createDraft()
    {
        Integer newId = number();

        return Event.draft( newId );
    }
}
