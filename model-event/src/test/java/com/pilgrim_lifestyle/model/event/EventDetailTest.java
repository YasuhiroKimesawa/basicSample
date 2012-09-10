package com.pilgrim_lifestyle.model.event;

import jp.pilgrim_ericclapton.model.primitive.date.format.DateStampFormat;
import jp.pilgrim_ericclapton.model.primitive.date.format.HourMinuteFormat;
import jp.pilgrim_ericclapton.model.primitive.date.format.TimeStampFormat;

import com.pilgrim_lifestyle.model.event.application.EndDate;
import com.pilgrim_lifestyle.model.event.application.Guideline;
import com.pilgrim_lifestyle.model.event.application.HeadCount;
import com.pilgrim_lifestyle.model.event.application.Period;
import com.pilgrim_lifestyle.model.event.application.StartDate;
import com.pilgrim_lifestyle.model.event.content.Content;
import com.pilgrim_lifestyle.model.event.content.DateOf;
import com.pilgrim_lifestyle.model.event.content.Explanation;
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
            String headCountStr = "";

            HeadCount headCount = new HeadCount( headCountStr );

            DateStampFormat startDateDateStamp = new DateStampFormat( "2011/01/01" );
            HourMinuteFormat startDateHourMinutes = new HourMinuteFormat( "10:30" );
            TimeStampFormat startDateFormat = new TimeStampFormat( startDateDateStamp, startDateHourMinutes );
            StartDate startDate = new StartDate( startDateFormat );

            DateStampFormat eneDateDateStamp = new DateStampFormat( "2011/03/01" );
            HourMinuteFormat endDateHourMinutes = new HourMinuteFormat( "10:30" );
            TimeStampFormat endDateFormat = new TimeStampFormat( eneDateDateStamp, endDateHourMinutes );
            EndDate endDate = new EndDate( endDateFormat );

            Period period = new Period( startDate, endDate );

            Guideline guideline = new Guideline( headCount, period );

            DateStampFormat dateOfDateDateStamp = new DateStampFormat( "2011/06/01" );
            HourMinuteFormat dateOfDateHourMinutes = new HourMinuteFormat( "10:30" );
            TimeStampFormat dateOfDateFormat = new TimeStampFormat( dateOfDateDateStamp, dateOfDateHourMinutes );
            DateOf dateOf = new DateOf( dateOfDateFormat );

            Explanation explanation = new Explanation( "イベントです。楽しいですよ" );

            Content content = new Content( dateOf, explanation );

            eventDetail = new EventDetail( guideline, content );
        }

        @Test
        public void validationが稼働する()
        {
            validateAndAssertCount( 2, eventDetail );
        }
    }

}
