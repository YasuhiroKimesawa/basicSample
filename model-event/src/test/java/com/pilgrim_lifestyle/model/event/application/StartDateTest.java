package com.pilgrim_lifestyle.model.event.application;

import static org.junit.Assert.*;

import java.text.ParseException;

import jp.pilgrim_ericclapton.model.primitive.date.format.DateStampFormat;
import jp.pilgrim_ericclapton.model.primitive.date.format.HourMinuteFormat;
import jp.pilgrim_ericclapton.model.primitive.date.format.TimeStampFormat;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import com.systemsekkei.base.test.model.BaseModelTest;

@RunWith( Enclosed.class )
public class StartDateTest
{

    public static class 正しい日付チェック extends BaseModelTest<StartDate>
    {
        @Test
        public void 正しくない日付() throws ParseException
        {
            DateStampFormat dateStampFormat = new DateStampFormat( "2012/01/aa" );
            HourMinuteFormat hourMinuteFormat = new HourMinuteFormat( "11:00" );
            TimeStampFormat timeStampFormat = new TimeStampFormat( dateStampFormat, hourMinuteFormat );
            StartDate startDate = new StartDate( timeStampFormat );

            assertFalse( startDate.isCollectFormat() );
        }

        @Test
        public void 正しい日付() throws ParseException
        {
            DateStampFormat dateStampFormat = new DateStampFormat( "2012/01/22" );
            HourMinuteFormat hourMinuteFormat = new HourMinuteFormat( "11:00" );
            TimeStampFormat timeStampFormat = new TimeStampFormat( dateStampFormat, hourMinuteFormat );
            StartDate startDate = new StartDate( timeStampFormat );

            assertTrue( startDate.isCollectFormat() );
        }
    }

    public static class 空日付チェック extends BaseModelTest<EndDate>
    {
        @Test
        public void 日付が空() throws ParseException
        {
            DateStampFormat dateStampFormat = new DateStampFormat( "" );
            HourMinuteFormat hourMinuteFormat = new HourMinuteFormat( "11:00" );
            TimeStampFormat timeStampFormat = new TimeStampFormat( dateStampFormat, hourMinuteFormat );
            StartDate startDate = new StartDate( timeStampFormat );

            assertTrue( startDate.isEmpty() );
        }

        @Test
        public void 時間が空() throws ParseException
        {
            DateStampFormat dateStampFormat = new DateStampFormat( "2012/01/22" );
            HourMinuteFormat hourMinuteFormat = new HourMinuteFormat( "" );
            TimeStampFormat timeStampFormat = new TimeStampFormat( dateStampFormat, hourMinuteFormat );
            StartDate startDate = new StartDate( timeStampFormat );

            assertTrue( startDate.isEmpty() );
        }

        @Test
        public void 両方空() throws ParseException
        {
            DateStampFormat dateStampFormat = new DateStampFormat( "" );
            HourMinuteFormat hourMinuteFormat = new HourMinuteFormat( "" );
            TimeStampFormat timeStampFormat = new TimeStampFormat( dateStampFormat, hourMinuteFormat );
            StartDate startDate = new StartDate( timeStampFormat );

            assertTrue( startDate.isEmpty() );
        }

        @Test
        public void 空ではない() throws ParseException
        {
            DateStampFormat dateStampFormat = new DateStampFormat( "2012/01/22" );
            HourMinuteFormat hourMinuteFormat = new HourMinuteFormat( "11：00" );
            TimeStampFormat timeStampFormat = new TimeStampFormat( dateStampFormat, hourMinuteFormat );
            StartDate startDate = new StartDate( timeStampFormat );

            assertFalse( startDate.isEmpty() );
        }
    }

}
