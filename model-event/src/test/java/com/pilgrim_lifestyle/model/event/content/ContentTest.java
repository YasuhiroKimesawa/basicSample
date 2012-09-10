package com.pilgrim_lifestyle.model.event.content;

import jp.pilgrim_ericclapton.model.primitive.date.format.DateStampFormat;
import jp.pilgrim_ericclapton.model.primitive.date.format.HourMinuteFormat;
import jp.pilgrim_ericclapton.model.primitive.date.format.TimeStampFormat;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import com.systemsekkei.base.test.model.BaseModelTest;

@RunWith( Enclosed.class )
public class ContentTest
{

    public static class EventDetailのバリデーションを実行する場合 extends BaseModelTest<Content>
    {
        private Content content;

        @Before
        public void setup()
        {
            DateStampFormat dateOfDateDateStamp = new DateStampFormat( "2011/aa/01" );
            HourMinuteFormat dateOfDateHourMinutes = new HourMinuteFormat( "10:30" );
            TimeStampFormat dateOfDateFormat = new TimeStampFormat( dateOfDateDateStamp, dateOfDateHourMinutes );
            DateOf dateOf = new DateOf( dateOfDateFormat );

            Explanation explanation = new Explanation( "" );

            content = new Content( dateOf, explanation );
        }

        @Test
        public void validationが稼働する()
        {
            validateAndAssertCount( 3, content );
        }
    }

}
