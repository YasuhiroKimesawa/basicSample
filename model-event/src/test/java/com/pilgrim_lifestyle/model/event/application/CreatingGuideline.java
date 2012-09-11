package com.pilgrim_lifestyle.model.event.application;

import java.util.Map;

import jp.pilgrim_ericclapton.model.primitive.date.format.DateStampFormat;
import jp.pilgrim_ericclapton.model.primitive.date.format.HourMinuteFormat;
import jp.pilgrim_ericclapton.model.primitive.date.format.TimeStampFormat;

import com.pilgrim_lifestyle.model.event.EventData;

public class CreatingGuideline
{
    Map<EventData, String> eventData;

    public static CreatingGuideline instansOf( Map<EventData, String> eventData )
    {
        return new CreatingGuideline( eventData );
    }

    private CreatingGuideline( Map<EventData, String> eventData )
    {
        this.eventData = eventData;
    }

    public Guideline createGuideline()
    {
        return new Guideline( createHeadCount(), createPeriod() );
    }

    public Period createPeriod()
    {
        return new Period( createStartDate(), createEndDate() );
    }

    public HeadCount createHeadCount()
    {
        return new HeadCount( eventData.get( EventData.応募人数 ) );
    }

    public StartDate createStartDate()
    {
        DateStampFormat dateStampFormat = new DateStampFormat( eventData.get( EventData.応募開始日にち ) );
        HourMinuteFormat hourMinuteFormat = new HourMinuteFormat( eventData.get( EventData.応募開始時間 ) );
        TimeStampFormat timeStampFormat = new TimeStampFormat( dateStampFormat, hourMinuteFormat );

        return new StartDate( timeStampFormat );
    }

    public EndDate createEndDate()
    {
        DateStampFormat dateStampFormat = new DateStampFormat( eventData.get( EventData.応募終了日にち ) );
        HourMinuteFormat hourMinuteFormat = new HourMinuteFormat( eventData.get( EventData.応募終了時間 ) );
        TimeStampFormat timeStampFormat = new TimeStampFormat( dateStampFormat, hourMinuteFormat );

        return new EndDate( timeStampFormat );
    }
}
