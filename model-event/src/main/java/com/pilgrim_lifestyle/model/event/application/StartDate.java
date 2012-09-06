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
public class StartDate
{
    private TimeStampFormat timeStampFormat;

    public StartDate( TimeStampFormat timeStampFormat )
    {
        this.timeStampFormat = timeStampFormat;
    }

    public static StartDate draft()
    {
        TimeStampFormat timeStampFormat = TimeStampFormat.draft();

        return new StartDate( timeStampFormat );
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

    @AssertFalse( message = "募集開始日時を入力して下さい。" )
    public boolean isEmpty()
    {
        return timeStampFormat.isEmpty();
    }

}
