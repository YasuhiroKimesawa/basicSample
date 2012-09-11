package com.pilgrim_lifestyle.model.event;

import java.util.Map;

import com.pilgrim_lifestyle.model.event.application.CreatingGuideline;
import com.pilgrim_lifestyle.model.event.application.Guideline;
import com.pilgrim_lifestyle.model.event.content.Content;
import com.pilgrim_lifestyle.model.event.content.CreatingContent;

public class CreatingEvent
{
    Map<EventData, String> eventData;

    public static CreatingEvent instansOf( Map<EventData, String> eventData )
    {
        return new CreatingEvent( eventData );
    }

    private CreatingEvent( Map<EventData, String> eventData )
    {
        this.eventData = eventData;
    }

    public Event createEvent()
    {
        String id = eventData.get( EventData.ID );
        String name = eventData.get( EventData.イベント名 );

        return new Event( Integer.valueOf( id ), name, createEventDetail() );
    }

    public EventDetail createEventDetail()
    {
        Guideline guideline = CreatingGuideline.instansOf( eventData ).createGuideline();

        Content content = CreatingContent.instansOf( eventData ).createContent();

        return new EventDetail( guideline, content );
    }
}
