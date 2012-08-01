package com.pilgrim_lifestyle.model.eventer.profile;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import com.systemsekkei.base.test.model.BaseModelTest;

@RunWith( Enclosed.class )
public class PersonNameTest extends BaseModelTest<PersonName>
{

    public static class エラーなし状態  extends BaseModelTest<PersonName>
    {
        PersonName name;

        @Before
        public void setup()
        {
            name = new PersonName( "１２３４５６７８９０１２", "１２３４５６７８９０１２" );
        }

        @Test
        public void エラーなし()
        {
            validateAndAssertCount( 0, name );
        }
    }

    public static class エラーあり状態 extends BaseModelTest<PersonName>
    {
        @Test
        public void 姓が空だとエラー()
        {
            PersonName name = new PersonName( "", "達也" );
            validateAndAssert( "lastName", NotEmpty.class, name );
        }

        @Test
        public void 名が空だとエラー()
        {
            PersonName name = new PersonName( "田中", "" );
            validateAndAssert( "firstName", NotEmpty.class, name );
        }

        @Test
        public void 姓が12を超えるとエラー()
        {
            PersonName name = new PersonName( "１２３４５６７８９０１２３", "達也" );
            validateAndAssert( "lastName", Length.class, name );
        }

        @Test
        public void 名が12を超えるとエラー()
        {
            PersonName name = new PersonName( "田中", "１２３４５６７８９０１２３" );
            validateAndAssert( "firstName", Length.class, name );
        }
    }

}
