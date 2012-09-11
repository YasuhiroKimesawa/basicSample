package com.pilgrim_lifestyle.model.eventer.personInfomation;

import java.util.HashMap;
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
            Map<EventerData, String> eventerData = new HashMap<EventerData, String>();
            eventerData.put( EventerData.メールアドレス, "mail@mail.com" );
            eventerData.put( EventerData.電話番号, "090-1111-2222" );
            eventerData.put( EventerData.姓, "" );
            eventerData.put( EventerData.名, "達也" );

            personalInfomation = CreatingPersonalInfomation.instansOf( eventerData ).createPersonalInfomation();
        }

        @Test
        public void EventerDetailのバリデーションが実行される()
        {
            validateAndAssertCount( 1, personalInfomation );
        }
    }
}
