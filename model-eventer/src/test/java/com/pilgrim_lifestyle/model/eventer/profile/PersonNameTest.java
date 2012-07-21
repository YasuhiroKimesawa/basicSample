package com.pilgrim_lifestyle.model.eventer.profile;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith( Enclosed.class )
public class PersonNameTest
{

    public static class 初期状態のとき
    {
        PersonName name;

        @Before
        public void init()
        {
            name = new PersonName( "田中", "達也" );
        }
    }

    @Test
    public void test()
    {
        fail( "まだ実装されていません" );
    }

}
