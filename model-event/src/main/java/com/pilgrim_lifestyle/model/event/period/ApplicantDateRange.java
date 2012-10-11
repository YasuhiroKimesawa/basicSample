package com.pilgrim_lifestyle.model.event.period;

import jp.pilgrim_ericclapton.model.primitive.date.format.TimeStampFormat;
import jp.pilgrim_ericclapton.model.primitive.date.range.TimeStampRange;

import java.text.ParseException;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApplicantDateRange
{
    private TimeStampFormat start;

    private TimeStampFormat end;

    public ApplicantDateRange( TimeStampFormat start, TimeStampFormat end )
    {
        this.start = start;
        this.end = end;
    }

    @AssertTrue( message = "終了日は開始日より後の日付で入力して下さい。")
    public boolean isCollect() throws ParseException
    {
        if( isEmpty() ) return true;
        return TimeStampRange.instanceOf( start, end ).isCollect();
    }

    @AssertTrue( message = "終了日は本日以降の日付を入力して下さい。")
    public boolean isAfterToday() throws ParseException
    {
        if( isEmpty() ) return true;
        return end.toDateStamp().isAfterToday();
    }

    @AssertFalse( message = "応募開始日と終了日を入力して下さい。" )
    public boolean isEmpty()
    {
        return start.isEmpty() || end.isEmpty();
    }

    public TimeStampFormat getEnd()
    {
        return end;
    }

    public static ApplicantDateRange draft()
    {
        TimeStampFormat start = TimeStampFormat.draft();
        TimeStampFormat end = TimeStampFormat.draft();

        return new ApplicantDateRange( start , end );
    }
}
