package com.pilgrim_lifestyle.model.event;

import java.util.Map;

import javax.validation.constraints.Size;

import com.systemsekkei.base.test.model.BaseModelTest;

import org.hibernate.validator.constraints.NotEmpty;
import org.junit.Test;

public class EventTest extends BaseModelTest<Event>
{
    private final Map<EventData.Data, String> eventData = new EventData().getData();

    private Event event = null;

    @Test
    public void eventDetailのvalidationが起動するか()
    {
        eventData.put( EventData.Data.HeadCount, "" );

        event = CreateEvent.createEvent( eventData );

        validateAndAssertCount( 1, event );
    }

    @Test
    public void nameはnotEmpty()
    {
        eventData.put( EventData.Data.NAME, "" );

        event = CreateEvent.createEvent( eventData );

        validateAndAssert( "name", NotEmpty.class, event );
    }

    @Test
    public void nameは51文字だとエラー()
    {
        eventData.put( EventData.Data.NAME, EventData.createStringDate( 51 ) );

        event = CreateEvent.createEvent( eventData );

        validateAndAssert( "name", Size.class, event );
    }

}
