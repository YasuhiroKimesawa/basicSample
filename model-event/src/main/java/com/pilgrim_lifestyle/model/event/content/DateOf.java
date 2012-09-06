package com.pilgrim_lifestyle.model.event.content;

import java.text.ParseException;

import jp.pilgrim_ericclapton.model.primitive.date.TimeStamp;
import jp.pilgrim_ericclapton.model.primitive.date.format.TimeStampFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DateOf
{
    private TimeStampFormat timeStampFormat;

    public TimeStamp getTimeStamp() throws ParseException
    {
        return timeStampFormat.getTimeStamp();
    }
}
