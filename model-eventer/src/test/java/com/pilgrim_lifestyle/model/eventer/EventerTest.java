package com.pilgrim_lifestyle.model.eventer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith( Enclosed.class )
public class EventerTest
{
    public static class 引数無し
    {
        Eventer eventer;

        @Before
        public void init()
        {
            eventer = new Eventer();
        }
    }

    @Test
    public void test()
    {
        fail( "まだ実装されていません" );
    }

}
