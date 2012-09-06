package com.pilgrim_lifestyle.model.event.application;

import java.text.ParseException;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;

import jp.pilgrim_ericclapton.model.primitive.date.TimeStamp;
import jp.pilgrim_ericclapton.model.primitive.date.format.TimeStampFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EndDate
{
    private TimeStampFormat timeStampFormat;

    public EndDate( TimeStampFormat timeStampFormat )
    {
        this.timeStampFormat = timeStampFormat;
    }

    public static EndDate draft()
    {
        TimeStampFormat timeStampFormat = TimeStampFormat.draft();

        return new EndDate( timeStampFormat );
    }

    public TimeStamp getTimeStamp() throws ParseException
    {
        return timeStampFormat.getTimeStamp();
    }

    @AssertTrue( message = "日付が正しくありません。" )
    public boolean isCollectFormat() throws ParseException
    {
        return timeStampFormat.canParse();
    }

    @AssertFalse( message = "募集終了日時を入力して下さい。" )
    public boolean isEmpty()
    {
        return timeStampFormat.isEmpty();
    }
}
