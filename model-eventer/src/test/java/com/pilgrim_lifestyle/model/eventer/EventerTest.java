package com.pilgrim_lifestyle.model.eventer;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import com.systemsekkei.base.test.model.BaseModelTest;

@RunWith( Enclosed.class )
public class EventerTest extends BaseModelTest<Eventer>
{
    public static class EventerDetailエラー状態 extends BaseModelTest<Eventer>
    {
        Eventer eventer;

        @Before
        public void setup()
        {
            Map<EventerData.Data, String> eventerData = new EventerData().getData();
            eventerData.put( EventerData.Data.姓, "" );

            eventer = CreateEventer.instansOf( eventerData ).createEventer();
        }

        @Test
        public void EventerDetailのバリデーションが実行される()
        {
            validateAndAssertCount( 1, eventer );
        }
    }
}
