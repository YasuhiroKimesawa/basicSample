package com.pilgrim_lifestyle.service.event;

import mockit.Deencapsulation;
import mockit.Expectations;

import org.junit.Test;

import com.pilgrim_lifestyle.model.event.Event;
import com.pilgrim_lifestyle.model.event.EventRepository;

public class RegisterEventServiceImplTest
{
    RegisterEventServiceImpl registerEventService = new RegisterEventServiceImpl();

    Event event = Event.draft( 1 );

    @Test
    public void イベントを登録する(final EventRepository eventRepository)
    {
        Deencapsulation.setField(registerEventService, eventRepository);

        new Expectations()
        {{
            eventRepository.register( event );
        }};

        registerEventService.register( event );
    }
}
