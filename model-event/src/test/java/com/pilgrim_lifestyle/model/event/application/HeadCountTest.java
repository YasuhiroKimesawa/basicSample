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
public class HeadCountTest
{

    public static class HeadCountのバリデーションを実行する場合 extends BaseModelTest<HeadCount>
    {
        private HeadCount headCount;

        @Before
        public void setup()
        {
            Map<EventData, String> eventData = new HashMap<EventData, String>();
            eventData.put( EventData.応募人数, "" );
            headCount = CreatingGuideline.instansOf( eventData ).createHeadCount();
        }

        @Test
        public void validationが稼働する()
        {
            validateAndAssertCount( 1, headCount );
        }
    }

}
