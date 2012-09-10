package com.pilgrim_lifestyle.model.event;

import com.pilgrim_lifestyle.model.event.application.EndDate;
import com.pilgrim_lifestyle.model.event.application.Guideline;
import com.pilgrim_lifestyle.model.event.application.HeadCount;
import com.pilgrim_lifestyle.model.event.application.Period;
import com.pilgrim_lifestyle.model.event.application.StartDate;
import com.pilgrim_lifestyle.model.event.content.Content;
import com.pilgrim_lifestyle.model.event.content.DateOf;
import com.pilgrim_lifestyle.model.event.content.Explanation;

import jp.pilgrim_ericclapton.model.primitive.date.format.DateStampFormat;
import jp.pilgrim_ericclapton.model.primitive.date.format.HourMinuteFormat;
import jp.pilgrim_ericclapton.model.primitive.date.format.TimeStampFormat;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


import com.systemsekkei.base.test.model.BaseModelTest;

@RunWith( Enclosed.class )
public class EventTest
{

    public static class Nameの文字数を変更した場合 extends BaseModelTest<Event>
    {
        private Event event;

        @Test
        public void 文字数が51文字以上の場合エラーになる()
        {
            String name = createName( 51 );

            event = new Event( 1, name, null );

            validateAndAssert( "name", Size.class, event );
        }

        @Test
        public void 文字数が50文字の場合エラーにならない()
        {
            String name = createName( 50 );

            event = new Event( 1, name, null );

            validateAndAssertCount( 0, event );
        }

        private String createName( int length )
        {
            StringBuffer buffer = new StringBuffer();

            for( int i = 0; i < length; i++ )
            {
                buffer.append( "a" );
            }
            assertThat( buffer.length(), is( length ) );

            return buffer.toString();
        }

        @Test
        public void 文字数が空文字の場合エラーになる()
        {
            String name = "";

            event = new Event( 1, name, null );

            validateAndAssertCount( 1, event );
        }
    }

    public static class EventDetailのバリデーションを実行する場合 extends BaseModelTest<HeadCount>
    {
        private Event event;

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

            Explanation explanation = new Explanation( "aaa" );

            Content content = new Content( dateOf, explanation );

            EventDetail eventDetail = new EventDetail( guideline, content );

            event = new Event( 1, "nameaaaaaa", eventDetail );
        }

        @Test
        public void validationが稼働する()
        {
            validateAndAssert( "headCount", NotEmpty.class, event.getEventDetail().getGuideline().getHeadCount() );
        }
    }

}
