package com.pilgrim_lifestyle.model.event.application;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import com.pilgrim_lifestyle.model.event.EventData;
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
            Map<EventData, String> eventData = new HashMap<EventData, String>();
            eventData.put( EventData.応募人数, "" );
            eventData.put( EventData.応募開始日にち, "2011/04/01" );
            eventData.put( EventData.応募開始時間, "10:30" );
            eventData.put( EventData.応募終了日にち, "2011/03/01" );
            eventData.put( EventData.応募終了時間, "10:30" );

            guideline = CreatingGuideline.instansOf( eventData ).createGuideline();
        }

        @Test
        public void validationが稼働する()
        {
            validateAndAssertCount( 2, guideline );
        }
    }

}
