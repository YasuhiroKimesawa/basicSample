package com.pilgrim_lifestyle.model.event;

import java.util.Map;

import com.pilgrim_lifestyle.model.event.content.Content;
import com.pilgrim_lifestyle.model.event.content.CreateContent;
import com.pilgrim_lifestyle.model.event.period.CreatePeriod;
import com.pilgrim_lifestyle.model.event.period.Period;

public class CreateEvent
{
    public static Event createEvent( Map<EventData.Data, String> eventData )
    {
        Integer id =  Integer.valueOf( eventData.get( EventData.Data.ID ) );
        String name = eventData.get( EventData.Data.NAME );
        EventDetail eventDetail = createEventDetail( eventData );

        return new Event( id, name, eventDetail );
    }

    public static EventDetail createEventDetail( Map<EventData.Data, String> eventData )
    {
        Period period = CreatePeriod.createPeriod( eventData );
        Content content = CreateContent.createContent( eventData );

        return new EventDetail( period, content );
    }
}
