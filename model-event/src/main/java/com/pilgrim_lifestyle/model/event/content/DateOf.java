package com.pilgrim_lifestyle.model.event.content;

import java.text.ParseException;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;

import jp.pilgrim_ericclapton.model.primitive.date.TimeStamp;
import jp.pilgrim_ericclapton.model.primitive.date.format.TimeStampFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DateOf
{
    private TimeStampFormat timeStampFormat;

    public DateOf( TimeStampFormat timeStampFormat )
    {
        this.timeStampFormat = timeStampFormat;
    }

    public TimeStamp getTimeStamp() throws ParseException
    {
        return timeStampFormat.getTimeStamp();
    }

    public static DateOf draft()
    {
        TimeStampFormat timeStampFormat = TimeStampFormat.draft();

        return new  DateOf( timeStampFormat );
    }

    @AssertTrue( message = "日付が正しくありません。" )
    public boolean isCollectFormat() throws ParseException
    {
        return timeStampFormat.canParse();
    }

    @AssertFalse( message = "開催日を入力して下さい。" )
    public boolean isEmpty()
    {
        return timeStampFormat.isEmpty();
    }
}
