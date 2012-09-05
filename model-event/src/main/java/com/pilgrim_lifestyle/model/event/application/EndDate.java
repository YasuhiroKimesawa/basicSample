package com.pilgrim_lifestyle.model.event.application;

import java.text.ParseException;

import jp.pilgrim_ericclapton.model.primitive.date.DataStampEmpty;
import jp.pilgrim_ericclapton.model.primitive.date.DateStamp;
import jp.pilgrim_ericclapton.model.primitive.date.HourAndMinute;
import jp.pilgrim_ericclapton.model.primitive.date.HourAndMinuteEmpty;
import jp.pilgrim_ericclapton.model.primitive.date.TimeStamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EndDate
{
    private DateStamp dateStamp;

    private HourAndMinute hourAndMinute;

    public TimeStamp getTimeStamp() throws ParseException
    {
        return TimeStamp.create( dateStamp, hourAndMinute );
    }

    // use framework
    public void setDateStamp( DateStamp dateStamp )
    {
        if( dateStamp.getDate() == null )
        {
            this.dateStamp = new DataStampEmpty();
            return;
        }

        this.dateStamp = dateStamp;
    }

    public void setHourAndMinute( HourAndMinute hourAndMinute )
    {
        if( hourAndMinute.getDate() == null )
        {
            this.hourAndMinute = new HourAndMinuteEmpty();
        }

        this.hourAndMinute = hourAndMinute;
    }
}
