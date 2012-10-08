package com.pilgrim_lifestyle.model.event;

import static org.junit.Assert.assertTrue;

import java.util.EnumMap;

public class EventData
{
    public static enum Data
    {
        ID
        , NAME
        , HeadCount
        , EXPLANATION
        , DATEOF_DATE
        , DATEOF_TIME
        , APPLICATION_DATE_RANGE_START_DATE
        , APPLICATION_DATE_RANGE_START_TIME
        , APPLICATION_DATE_RANGE_END_DATE
        , APPLICATION_DATE_RANGE_END_TIME;
    }

    private EnumMap<Data, String> data = new EnumMap<Data, String>( Data.class );

    public EventData()
    {
        data.put( Data.ID, "1" );
        data.put( Data.NAME, "勉強会" );
        data.put( Data.HeadCount, "30" );
        data.put( Data.EXPLANATION, "Javaの勉強会です" );
        data.put( Data.DATEOF_DATE, "2012/10/01" );
        data.put( Data.DATEOF_TIME, "17:00" );
        data.put( Data.APPLICATION_DATE_RANGE_START_DATE, "2012/08/01" );
        data.put( Data.APPLICATION_DATE_RANGE_START_TIME, "17:00" );
        data.put( Data.APPLICATION_DATE_RANGE_END_DATE, "2012/09/01" );
        data.put( Data.APPLICATION_DATE_RANGE_END_TIME, "17:00" );
    }

    public EnumMap<Data, String> getData()
    {
        return data;
    }

    public static String createStringDate( int count )
    {
        String result = "";
        for( int i = 0; i < count; i++ )
        {
            result = result + "a";
        }

        assertTrue( result.length() == count );

        return result;
    }
}