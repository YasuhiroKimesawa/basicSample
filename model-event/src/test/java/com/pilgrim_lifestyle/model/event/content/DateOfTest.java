package com.pilgrim_lifestyle.model.event.content;

import com.pilgrim_lifestyle.model.event.EventData;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import com.systemsekkei.base.test.model.BaseModelTest;

@RunWith( Enclosed.class )
public class DateOfTest
{
    private static DateOf createDateOf( String date, String hour )
    {
        Map<EventData, String> eventData = new HashMap<EventData, String>();
        eventData.put( EventData.開催日にち, date );
        eventData.put( EventData.開催時間,  hour);
        DateOf dateOf = CreatingContent.instansOf( eventData ).createDateOf( eventData );
        return dateOf;
    }

    public static class 正しい日付チェック extends BaseModelTest<DateOf>
    {
        @Test
        public void 正しくない日付() throws ParseException
        {
            DateOf dateOf = createDateOf( "2012/01/aa", "11:00" );

            assertFalse( dateOf.isCollectFormat() );
        }

        @Test
        public void 正しい日付() throws ParseException
        {
            DateOf dateOf = createDateOf( "2012/01/22", "11:00" );

            assertTrue( dateOf.isCollectFormat() );
        }
    }

    public static class 空日付チェック extends BaseModelTest<DateOf>
    {
        @Test
        public void 日付が空() throws ParseException
        {
            DateOf dateOf = createDateOf( "", "11:00" );

            assertTrue( dateOf.isEmpty() );
        }

        @Test
        public void 時間が空() throws ParseException
        {
            DateOf dateOf = createDateOf( "2012/01/22", "" );

            assertTrue( dateOf.isEmpty() );
        }

        @Test
        public void 両方空() throws ParseException
        {
            DateOf dateOf = createDateOf( "", "" );

            assertTrue( dateOf.isEmpty() );
        }

        @Test
        public void 空ではない() throws ParseException
        {
            DateOf dateOf = createDateOf( "2012/01/22", "11：00" );

            assertFalse( dateOf.isEmpty() );
        }
    }

    public static class 今日以降チェック extends BaseModelTest<DateOf>
    {
        @Test
        public void 今日より前() throws ParseException
        {
            DateOf dateOf = createDateOf( "2012/01/22", "11：00" );

            assertFalse( dateOf.isAfterToday() );
        }

        @Test
        public void 今日より後() throws ParseException
        {
            DateOf dateOf = createDateOf( plusFromTodayDate( 1 ), "11：00" );

            assertTrue( dateOf.isAfterToday() );
        }

        @Test
        public void 今日() throws ParseException
        {
            DateOf dateOf = createDateOf( plusFromTodayDate( 0 ), "11：00" );

            assertFalse( dateOf.isAfterToday() );
        }

        private String plusFromTodayDate( int plus )
        {
            Calendar calendar = Calendar.getInstance( Locale.JAPAN );
            calendar.add( Calendar.DAY_OF_MONTH, plus );

            return new SimpleDateFormat( "yyyy/MM/dd", Locale.JAPANESE ).format( calendar.getTime() );
        }
    }
}
