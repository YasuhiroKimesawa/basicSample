package com.pilgrim_lifestyle.model.eventer.personInfomation;

import java.util.Map;

import com.pilgrim_lifestyle.model.eventer.EventerData;
import com.systemsekkei.base.test.model.BaseModelTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith( Enclosed.class )
public class PersonalInfomationTest
{
    public static class PersonalInfomationエラー状態 extends BaseModelTest<PersonalInfomation>
    {
        PersonalInfomation personalInfomation;

        @Before
        public void setup()
        {
            Map<EventerData.Data, String> eventerData = new EventerData().getData();
            eventerData.put( EventerData.Data.姓, "" );

            personalInfomation = CreatingPersonalInfomation.createPersonalInfomation( eventerData );
        }

        @Test
        public void EventerDetailのバリデーションが実行される()
        {
            validateAndAssertCount( 1, personalInfomation );
        }
    }
}
