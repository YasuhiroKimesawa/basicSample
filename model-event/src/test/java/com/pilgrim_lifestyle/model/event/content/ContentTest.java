package com.pilgrim_lifestyle.model.event.content;

import com.pilgrim_lifestyle.model.event.EventData;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import com.systemsekkei.base.test.model.BaseModelTest;

@RunWith( Enclosed.class )
public class ContentTest
{

    public static class EventDetailのバリデーションを実行する場合 extends BaseModelTest<Content>
    {
        private Content content;

        @Before
        public void setup()
        {
            Map<EventData, String> eventData = new HashMap<EventData, String>();
            eventData.put( EventData.開催日にち, "2011/aa/01" );
            eventData.put( EventData.開催時間, "10:30" );

            eventData.put( EventData.説明, "" );

            content = CreatingContent.instansOf( eventData ).createContent();
        }

        @Test
        public void validationが稼働する()
        {
            validateAndAssertCount( 3, content );
        }
    }

}
