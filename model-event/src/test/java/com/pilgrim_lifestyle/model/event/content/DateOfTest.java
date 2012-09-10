package com.pilgrim_lifestyle.model.event.content;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import jp.pilgrim_ericclapton.model.primitive.date.format.DateStampFormat;
import jp.pilgrim_ericclapton.model.primitive.date.format.HourMinuteFormat;
import jp.pilgrim_ericclapton.model.primitive.date.format.TimeStampFormat;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import com.systemsekkei.base.test.model.BaseModelTest;

@RunWith( Enclosed.class )
public class DateOfTest
{

    public static class 正しい日付チェック extends BaseModelTest<DateOf>
    {
        @Test
        public void 正しくない日付() throws ParseException
        {
            DateStampFormat dateStampFormat = new DateStampFormat( "2012/01/aa" );
            HourMinuteFormat hourMinuteFormat = new HourMinuteFormat( "11:00" );
            TimeStampFormat timeStampFormat = new TimeStampFormat( dateStampFormat, hourMinuteFormat );
            DateOf dateOf = new DateOf( timeStampFormat );

            assertFalse( dateOf.isCollectFormat() );
        }

        @Test
        public void 正しい日付() throws ParseException
        {
            DateStampFormat dateStampFormat = new DateStampFormat( "2012/01/22" );
            HourMinuteFormat hourMinuteFormat = new HourMinuteFormat( "11:00" );
            TimeStampFormat timeStampFormat = new TimeStampFormat( dateStampFormat, hourMinuteFormat );
            DateOf dateOf = new DateOf( timeStampFormat );

            assertTrue( dateOf.isCollectFormat() );
        }
    }

    public static class 空日付チェック extends BaseModelTest<DateOf>
    {
        @Test
        public void 日付が空() throws ParseException
        {
            DateStampFormat dateStampFormat = new DateStampFormat( "" );
            HourMinuteFormat hourMinuteFormat = new HourMinuteFormat( "11:00" );
            TimeStampFormat timeStampFormat = new TimeStampFormat( dateStampFormat, hourMinuteFormat );
            DateOf dateOf = new DateOf( timeStampFormat );

            assertTrue( dateOf.isEmpty() );
        }

        @Test
        public void 時間が空() throws ParseException
        {
            DateStampFormat dateStampFormat = new DateStampFormat( "2012/01/22" );
            HourMinuteFormat hourMinuteFormat = new HourMinuteFormat( "" );
            TimeStampFormat timeStampFormat = new TimeStampFormat( dateStampFormat, hourMinuteFormat );
            DateOf dateOf = new DateOf( timeStampFormat );

            assertTrue( dateOf.isEmpty() );
        }

        @Test
        public void 両方空() throws ParseException
        {
            DateStampFormat dateStampFormat = new DateStampFormat( "" );
            HourMinuteFormat hourMinuteFormat = new HourMinuteFormat( "" );
            TimeStampFormat timeStampFormat = new TimeStampFormat( dateStampFormat, hourMinuteFormat );
            DateOf dateOf = new DateOf( timeStampFormat );

            assertTrue( dateOf.isEmpty() );
        }

        @Test
        public void 空ではない() throws ParseException
        {
            DateStampFormat dateStampFormat = new DateStampFormat( "2012/01/22" );
            HourMinuteFormat hourMinuteFormat = new HourMinuteFormat( "11：00" );
            TimeStampFormat timeStampFormat = new TimeStampFormat( dateStampFormat, hourMinuteFormat );
            DateOf dateOf = new DateOf( timeStampFormat );

            assertFalse( dateOf.isEmpty() );
        }
    }

    public static class 今日以降チェック extends BaseModelTest<DateOf>
    {
        @Test
        public void 今日より前() throws ParseException
        {
            DateStampFormat dateStampFormat = new DateStampFormat( "2012/01/22" );
            HourMinuteFormat hourMinuteFormat = new HourMinuteFormat( "11:00" );
            TimeStampFormat timeStampFormat = new TimeStampFormat( dateStampFormat, hourMinuteFormat );
            DateOf dateOf = new DateOf( timeStampFormat );

            assertFalse( dateOf.isAfterToday() );
        }

        @Test
        public void 今日より後() throws ParseException
        {
            Calendar calendar = Calendar.getInstance( Locale.JAPAN );
            calendar.add( Calendar.DAY_OF_MONTH, 1 );

            String tommorowDate = new SimpleDateFormat( "yyyy/MM/dd", Locale.JAPANESE ).format( calendar.getTime() );
            DateStampFormat dateStampFormat = new DateStampFormat( tommorowDate );

            String tommorowTime = new SimpleDateFormat( "kk:mm", Locale.JAPANESE ).format( calendar.getTime() );
            HourMinuteFormat hourMinuteFormat = new HourMinuteFormat( tommorowTime );

            TimeStampFormat timeStampFormat = new TimeStampFormat( dateStampFormat, hourMinuteFormat );
            DateOf dateOf = new DateOf( timeStampFormat );

            assertTrue( dateOf.isAfterToday() );
        }

        @Test
        public void 今日() throws ParseException
        {
            Calendar calendar = Calendar.getInstance( Locale.JAPAN );

            String tommorowDate = new SimpleDateFormat( "yyyy/MM/dd", Locale.JAPANESE ).format( calendar.getTime() );
            DateStampFormat dateStampFormat = new DateStampFormat( tommorowDate );

            String tommorowTime = new SimpleDateFormat( "kk:mm", Locale.JAPANESE ).format( calendar.getTime() );
            HourMinuteFormat hourMinuteFormat = new HourMinuteFormat( tommorowTime );

            TimeStampFormat timeStampFormat = new TimeStampFormat( dateStampFormat, hourMinuteFormat );
            DateOf dateOf = new DateOf( timeStampFormat );

            assertFalse( dateOf.isAfterToday() );
        }
    }
}
