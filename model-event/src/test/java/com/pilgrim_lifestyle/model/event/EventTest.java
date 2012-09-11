package com.pilgrim_lifestyle.model.event;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import javax.validation.constraints.Size;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


import com.systemsekkei.base.test.model.BaseModelTest;

@RunWith( Enclosed.class )
public class EventTest
{

    public static class Nameの文字数を変更した場合 extends BaseModelTest<Event>
    {
        private Event event;

        @Test
        public void 文字数が51文字以上の場合エラーになる()
        {
            String name = createName( 51 );

            event = new Event( 1, name, null );

            validateAndAssert( "name", Size.class, event );
        }

        @Test
        public void 文字数が50文字の場合エラーにならない()
        {
            String name = createName( 50 );

            event = new Event( 1, name, null );

            validateAndAssertCount( 0, event );
        }

        private String createName( int length )
        {
            StringBuffer buffer = new StringBuffer();

            for( int i = 0; i < length; i++ )
            {
                buffer.append( "a" );
            }
            assertThat( buffer.length(), is( length ) );

            return buffer.toString();
        }

        @Test
        public void 文字数が空文字の場合エラーになる()
        {
            String name = "";

            event = new Event( 1, name, null );

            validateAndAssertCount( 1, event );
        }
    }

    public static class EventDetailのバリデーションを実行する場合 extends BaseModelTest<Event>
    {
        private Event event;

        @Before
        public void setup()
        {
            Map<EventData, String> eventData = new HashMap<EventData, String>();
            eventData.put( EventData.応募人数, "" );

            eventData.put( EventData.ID, "1" );
            eventData.put( EventData.イベント名, "イベント" );
            eventData.put( EventData.応募開始日にち, "2011/01/01" );
            eventData.put( EventData.応募開始時間, "10:30" );
            eventData.put( EventData.応募終了日にち, "2011/03/01" );
            eventData.put( EventData.応募終了時間, "10:30" );
            eventData.put( EventData.開催日にち, "2011/06/01" );
            eventData.put( EventData.開催時間, "10:30" );
            eventData.put( EventData.説明, "イベントです。楽しいですよ" );

            event = CreatingEvent.instansOf( eventData ).createEvent();
        }

        @Test
        public void validationが稼働する()
        {
            validateAndAssertCount( 2, event );
        }
    }

}
