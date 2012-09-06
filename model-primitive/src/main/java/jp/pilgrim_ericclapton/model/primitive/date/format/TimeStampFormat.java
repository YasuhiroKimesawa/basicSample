package jp.pilgrim_ericclapton.model.primitive.date.format;

import java.text.ParseException;

import jp.pilgrim_ericclapton.model.primitive.date.TimeStamp;
import lombok.NoArgsConstructor;

import lombok.Data;

@Data
@NoArgsConstructor
public class TimeStampFormat
{
    private DateStampFormat dateStamp;

    private HourMinuteFormat hourMinute;

    public boolean isEmpty()
    {
        return dateStamp.isEmpty() || hourMinute.isEmpty();
    }

    public String dateStampAsText()
    {
        return dateStamp.getDateStamp();
    }

    public String hourMinuteAsText()
    {
        return hourMinute.getHourMinute();
    }

    public TimeStamp getTimeStamp() throws ParseException
    {
        return TimeStamp.create( this );
    }
}
