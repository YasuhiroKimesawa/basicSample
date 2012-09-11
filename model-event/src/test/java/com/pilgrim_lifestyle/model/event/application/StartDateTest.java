package com.pilgrim_lifestyle.model.event.application;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import com.pilgrim_lifestyle.model.event.EventData;
import com.systemsekkei.base.test.model.BaseModelTest;

@RunWith( Enclosed.class )
public class StartDateTest
{
    private static StartDate createStartDate( String date, String hour )
    {
        Map<EventData, String> eventData = new HashMap<EventData, String>();
        eventData.put( EventData.応募開始日にち, date );
        eventData.put( EventData.応募開始時間,  hour );
        return CreatingGuideline.instansOf( eventData ).createStartDate();
    }

    public static class 正しい日付チェック extends BaseModelTest<StartDate>
    {
        @Test
        public void 正しくない日付() throws ParseException
        {
            StartDate startDate = createStartDate( "2012/01/aa", "11:00" );

            assertFalse( startDate.isCollectFormat() );
        }

        @Test
        public void 正しい日付() throws ParseException
        {
            StartDate startDate = createStartDate( "2012/01/22", "11:00" );

            assertTrue( startDate.isCollectFormat() );
        }
    }

    public static class 空日付チェック extends BaseModelTest<EndDate>
    {
        @Test
        public void 日付が空() throws ParseException
        {
            StartDate startDate = createStartDate( "", "11:00" );

            assertTrue( startDate.isEmpty() );
        }

        @Test
        public void 時間が空() throws ParseException
        {
            StartDate startDate = createStartDate( "2012/01/22", "" );

            assertTrue( startDate.isEmpty() );
        }

        @Test
        public void 両方空() throws ParseException
        {
            StartDate startDate = createStartDate( "", "" );

            assertTrue( startDate.isEmpty() );
        }

        @Test
        public void 空ではない() throws ParseException
        {
            StartDate startDate = createStartDate( "2012/01/22", "11：00" );

            assertFalse( startDate.isEmpty() );
        }
    }

}
