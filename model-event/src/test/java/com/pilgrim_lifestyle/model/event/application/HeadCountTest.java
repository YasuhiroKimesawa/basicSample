package com.pilgrim_lifestyle.model.event.application;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

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
            String headCountStr = "";

            headCount = new HeadCount( headCountStr );
        }

        @Test
        public void validationが稼働する()
        {
            validateAndAssertCount( 1, headCount );
        }
    }

}
