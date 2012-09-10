package com.pilgrim_lifestyle.model.event.application;

import javax.validation.constraints.AssertTrue;

import jp.pilgrim_ericclapton.model.primitive.date.format.DateStampFormat;
import jp.pilgrim_ericclapton.model.primitive.date.format.HourMinuteFormat;
import jp.pilgrim_ericclapton.model.primitive.date.format.TimeStampFormat;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import com.systemsekkei.base.test.model.BaseModelTest;

@RunWith( Enclosed.class )
public class PeriodTest
{

    public static class Periodのバリデーションを実行する場合 extends BaseModelTest<Period>
    {
        private Period period;

        @Before
        public void setup()
        {
            DateStampFormat startDateDateStamp = new DateStampFormat( "2011/01/aa" );
            HourMinuteFormat startDateHourMinutes = new HourMinuteFormat( "10:30" );
            TimeStampFormat startDateFormat = new TimeStampFormat( startDateDateStamp, startDateHourMinutes );
            StartDate startDate = new StartDate( startDateFormat );

            DateStampFormat eneDateDateStamp = new DateStampFormat( "2011/03/01" );
            HourMinuteFormat endDateHourMinutes = new HourMinuteFormat( "10:aa" );
            TimeStampFormat endDateFormat = new TimeStampFormat( eneDateDateStamp, endDateHourMinutes );
            EndDate endDate = new EndDate( endDateFormat );

            period = new Period( startDate, endDate );
        }

        @Test
        public void validationが稼働する()
        {
            validateAndAssertCount( 3, period );
        }
    }

    public static class Periodの日付前後チェックをする場合 extends BaseModelTest<Period>
    {
        private Period period;

        @Before
        public void setup()
        {
            DateStampFormat startDateDateStamp = new DateStampFormat( "2011/05/11" );
            HourMinuteFormat startDateHourMinutes = new HourMinuteFormat( "10:30" );
            TimeStampFormat startDateFormat = new TimeStampFormat( startDateDateStamp, startDateHourMinutes );
            StartDate startDate = new StartDate( startDateFormat );

            DateStampFormat eneDateDateStamp = new DateStampFormat( "2011/03/01" );
            HourMinuteFormat endDateHourMinutes = new HourMinuteFormat( "10:00" );
            TimeStampFormat endDateFormat = new TimeStampFormat( eneDateDateStamp, endDateHourMinutes );
            EndDate endDate = new EndDate( endDateFormat );

            period = new Period( startDate, endDate );
        }

        @Test
        public void validationが稼働する()
        {
            validateAndAssert( "afterEndDate", AssertTrue.class, period );
        }
    }

}
