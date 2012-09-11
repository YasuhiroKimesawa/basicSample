package com.pilgrim_lifestyle.model.event.application;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.AssertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import com.pilgrim_lifestyle.model.event.EventData;
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
            Map<EventData, String> eventData = new HashMap<EventData, String>();
            eventData.put( EventData.応募開始日にち, "2011/01/aa" );
            eventData.put( EventData.応募開始時間, "10:30" );
            eventData.put( EventData.応募終了日にち, "2011/03/aa" );
            eventData.put( EventData.応募終了時間, "10:30" );

            period = CreatingGuideline.instansOf( eventData ).createPeriod();
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
            Map<EventData, String> eventData = new HashMap<EventData, String>();
            eventData.put( EventData.応募開始日にち, "2011/05/11" );
            eventData.put( EventData.応募開始時間, "10:30" );
            eventData.put( EventData.応募終了日にち, "2011/03/01" );
            eventData.put( EventData.応募終了時間, "10:30" );

            period = CreatingGuideline.instansOf( eventData ).createPeriod();
        }

        @Test
        public void validationが稼働する()
        {
            validateAndAssert( "afterEndDate", AssertTrue.class, period );
        }
    }

}
