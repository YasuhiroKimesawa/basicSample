package com.pilgrim_lifestyle.model.event.content;

import java.text.ParseException;

import org.hibernate.validator.constraints.NotEmpty;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import com.systemsekkei.base.test.model.BaseModelTest;

@RunWith( Enclosed.class )
public class ExplanationTest
{

    public static class 空チェック extends BaseModelTest<Explanation>
    {
        @Test
        public void 空() throws ParseException
        {
            Explanation explanation = new Explanation( "" );

            validateAndAssert( "explanation", NotEmpty.class, explanation );
        }

        @Test
        public void 入力有り() throws ParseException
        {
            Explanation explanation = new Explanation( "ああ" );

            validateAndAssertCount( 0, explanation );
        }
    }

}
