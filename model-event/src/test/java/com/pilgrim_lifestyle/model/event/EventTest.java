package com.pilgrim_lifestyle.model.event;

import java.util.Map;

import com.systemsekkei.base.test.model.BaseModelTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith( Enclosed.class )
public class EventTest
{

    public static class validationが起動するか extends BaseModelTest<Event>
    {
        private Event event = null;

        @Before
        public void setup()
        {
            Map<EventData.Data, String> eventData = EventData.getData();
            eventData.put( EventData.Data.ID, "0" );
            eventData.put( EventData.Data.NAME, "" );
            eventData.put( EventData.Data.HeadCount, "" );

            event = CreateEvent.createEvent( eventData );
        }

        @Test
        public void validationが起動する()
        {
            validateAndAssertCount( 2, event );
        }
    }

}
