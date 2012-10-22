package com.pilgrim_lifestyle.model.eventer;

import java.util.Map;

import com.systemsekkei.base.test.model.BaseModelTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith( Enclosed.class )
public class EventerDetailTest
{
    public static class EventerDetailエラー状態 extends BaseModelTest<EventerDetail>
    {
        EventerDetail eventer;

        @Before
        public void setup()
        {
            Map<EventerData.Data, String> eventerData = new EventerData().getData();
            eventerData.put( EventerData.Data.姓, "" );


            eventer = CreateEventer.createEventerDetail( eventerData );
        }

        @Test
        public void EventerDetailのバリデーションが実行される()
        {
            validateAndAssertCount( 1, eventer );
        }
    }

}
