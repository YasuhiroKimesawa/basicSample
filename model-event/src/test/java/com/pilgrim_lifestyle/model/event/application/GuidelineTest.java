package com.pilgrim_lifestyle.model.event.application;

import jp.pilgrim_ericclapton.model.primitive.date.format.DateStampFormat;
import jp.pilgrim_ericclapton.model.primitive.date.format.HourMinuteFormat;
import jp.pilgrim_ericclapton.model.primitive.date.format.TimeStampFormat;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import com.systemsekkei.base.test.model.BaseModelTest;

@RunWith( Enclosed.class )
public class GuidelineTest
{

    public static class Guidelineのバリデーションを実行する場合 extends BaseModelTest<Guideline>
    {
        private Guideline guideline;

        @Before
        public void setup()
        {
            String headCountStr = "";

            HeadCount headCount = new HeadCount( headCountStr );

            DateStampFormat startDateDateStamp = new DateStampFormat( "2011/04/01" );
            HourMinuteFormat startDateHourMinutes = new HourMinuteFormat( "10:30" );
            TimeStampFormat startDateFormat = new TimeStampFormat( startDateDateStamp, startDateHourMinutes );
            StartDate startDate = new StartDate( startDateFormat );

            DateStampFormat eneDateDateStamp = new DateStampFormat( "2011/03/01" );
            HourMinuteFormat endDateHourMinutes = new HourMinuteFormat( "10:30" );
            TimeStampFormat endDateFormat = new TimeStampFormat( eneDateDateStamp, endDateHourMinutes );
            EndDate endDate = new EndDate( endDateFormat );

            Period period = new Period( startDate, endDate );

            guideline = new Guideline( headCount, period );
        }

        @Test
        public void validationが稼働する()
        {
            validateAndAssertCount( 2, guideline );
        }
    }

}
