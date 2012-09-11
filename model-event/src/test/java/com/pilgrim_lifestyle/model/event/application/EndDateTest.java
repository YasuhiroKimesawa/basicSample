package com.pilgrim_lifestyle.model.event.application;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.pilgrim_lifestyle.model.event.EventData;
import com.systemsekkei.base.test.model.BaseModelTest;

@RunWith( Enclosed.class )
public class EndDateTest
{
    private static EndDate createEndDate( String date, String hour )
    {
        Map<EventData, String> eventData = new HashMap<EventData, String>();
        eventData.put( EventData.応募終了日にち, date );
        eventData.put( EventData.応募終了時間,  hour );
        return CreatingGuideline.instansOf( eventData ).createEndDate();
    }

    public static class 正しい日付チェック extends BaseModelTest<EndDate>
    {
        @Test
        public void 正しくない日付() throws ParseException
        {
            EndDate endDate = createEndDate( "2012/01/aa", "11:00" );

            assertFalse( endDate.isCollectFormat() );
        }

        @Test
        public void 正しい日付() throws ParseException
        {
            EndDate endDate = createEndDate( "2012/01/22", "11:00" );

            assertTrue( endDate.isCollectFormat() );
        }
    }

    public static class 空日付チェック extends BaseModelTest<EndDate>
    {
        @Test
        public void 日付が空() throws ParseException
        {
            EndDate endDate = createEndDate( "", "11:00" );

            assertTrue( endDate.isEmpty() );
        }

        @Test
        public void 時間が空() throws ParseException
        {
            EndDate endDate = createEndDate( "2012/01/22", "" );

            assertTrue( endDate.isEmpty() );
        }

        @Test
        public void 両方空() throws ParseException
        {
            EndDate endDate = createEndDate( "", "" );

            assertTrue( endDate.isEmpty() );
        }

        @Test
        public void 空ではない() throws ParseException
        {
            EndDate endDate = createEndDate( "2012/01/22", "11：00" );

            assertFalse( endDate.isEmpty() );
        }
    }

}
