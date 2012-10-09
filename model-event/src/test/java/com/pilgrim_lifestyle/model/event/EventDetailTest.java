package com.pilgrim_lifestyle.model.event;

import java.util.Map;

import org.junit.Test;

import com.systemsekkei.base.test.model.BaseModelTest;

public class EventDetailTest extends BaseModelTest<EventDetail>
{
    private final Map<EventData.Data, String> eventData = new EventData().getData();

    private EventDetail eventDetail = null;

    @Test
    public void validationが起動するか()
    {
        eventData.put( EventData.Data.HeadCount, "" );
        eventData.put( EventData.Data.DATEOF_DATE, "2000/01/01" );

        eventDetail = CreateEvent.createEventDetail( eventData );

        validateAndAssertCount( 2, eventDetail );
    }

}
