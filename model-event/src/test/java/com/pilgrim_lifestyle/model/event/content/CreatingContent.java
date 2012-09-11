package com.pilgrim_lifestyle.model.event.content;

import java.util.Map;

import jp.pilgrim_ericclapton.model.primitive.date.format.DateStampFormat;
import jp.pilgrim_ericclapton.model.primitive.date.format.HourMinuteFormat;
import jp.pilgrim_ericclapton.model.primitive.date.format.TimeStampFormat;

import com.pilgrim_lifestyle.model.event.EventData;
import com.pilgrim_lifestyle.model.event.content.Content;
import com.pilgrim_lifestyle.model.event.content.DateOf;
import com.pilgrim_lifestyle.model.event.content.Explanation;

public class CreatingContent
{
    Map<EventData, String> eventData;

    public static CreatingContent instansOf( Map<EventData, String> eventData )
    {
        return new CreatingContent( eventData );
    }

    private CreatingContent( Map<EventData, String> eventData )
    {
        this.eventData = eventData;
    }

    public Content createContent()
    {
        return new Content( createDateOf( eventData ), createExplanation( eventData ) );
    }

    public DateOf createDateOf( Map<EventData, String> eventData )
    {
        DateStampFormat dateStampFormat = new DateStampFormat( eventData.get( EventData.開催日にち ) );
        HourMinuteFormat hourMinuteFormat = new HourMinuteFormat( eventData.get( EventData.開催時間 ) );

        TimeStampFormat timeStampFormat = new TimeStampFormat( dateStampFormat, hourMinuteFormat );
        return new DateOf( timeStampFormat );
    }

    public Explanation createExplanation( Map<EventData, String> eventData )
    {
        return new Explanation( eventData.get( EventData.説明 ) );
    }
}
