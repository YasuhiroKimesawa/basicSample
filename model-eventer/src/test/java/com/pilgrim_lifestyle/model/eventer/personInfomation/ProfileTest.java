package com.pilgrim_lifestyle.model.eventer.personInfomation;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import com.pilgrim_lifestyle.model.eventer.personInfomation.PersonName;
import com.pilgrim_lifestyle.model.eventer.personInfomation.Profile;
import com.systemsekkei.base.test.model.BaseModelTest;

@RunWith( Enclosed.class )
public class ProfileTest extends BaseModelTest<Profile>
{
    public static class エラーあり状態 extends BaseModelTest<Profile>
    {
        Profile profile;

        @Before
        public void setup()
        {
            PersonName personName = new PersonName( "", "達也" );
            profile = new Profile( personName );
            profile.toString();
        }

        @Test
        public void PersonNameのバリデーションが実行される()
        {
            validateAndAssertCount( 1, profile );
        }
    }

}
