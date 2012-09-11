package com.pilgrim_lifestyle.model.event;

import java.util.HashMap;
import java.util.Map;

import com.systemsekkei.base.test.model.BaseModelTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith( Enclosed.class )
public class EventDetailTest
{

    public static class EventDetailのバリデーションを実行する場合 extends BaseModelTest<EventDetail>
    {
        private EventDetail eventDetail;

        @Before
        public void setup()
        {
            Map<EventData, String> eventData = new HashMap<EventData, String>();
            eventData.put( EventData.応募人数, "" );

            eventData.put( EventData.応募開始日にち, "2011/01/01" );
            eventData.put( EventData.応募開始時間, "10:30" );
            eventData.put( EventData.応募終了日にち, "2011/03/01" );
            eventData.put( EventData.応募終了時間, "10:30" );
            eventData.put( EventData.開催日にち, "2011/06/01" );
            eventData.put( EventData.開催時間, "10:30" );
            eventData.put( EventData.説明, "イベントです。楽しいですよ" );

            eventDetail = CreatingEvent.instansOf( eventData ).createEventDetail();
        }

        @Test
        public void validationが稼働する()
        {
            validateAndAssertCount( 2, eventDetail );
        }
    }

}
