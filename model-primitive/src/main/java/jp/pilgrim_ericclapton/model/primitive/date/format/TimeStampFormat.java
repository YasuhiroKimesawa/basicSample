package jp.pilgrim_ericclapton.model.primitive.date.format;

import jp.pilgrim_ericclapton.model.primitive.date.TimeStamp;
import jp.pilgrim_ericclapton.model.primitive.date.TimeStampEmpty;

import java.text.ParseException;

import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
public class TimeStampFormat
{
    private DateStampFormat dateStamp;

    private HourMinuteFormat hourMinute;

    public TimeStampFormat( DateStampFormat dateStamp, HourMinuteFormat hourMinute )
    {
        this.dateStamp = dateStamp;
        this.hourMinute = hourMinute;
    }

    public static TimeStampFormat draft()
    {
        DateStampFormat dateStampFormat = new DateStampFormat( "" );
        HourMinuteFormat hourMinuteFormat = new HourMinuteFormat( "" );

        return new TimeStampFormat( dateStampFormat, hourMinuteFormat );
    }

    public boolean isEmpty()
    {
        return dateStamp.isEmpty() || hourMinute.isEmpty();
    }

    public String timeStampAsText()
    {
        return String.format( "%s %s", dateStampAsText(),  hourMinuteAsText() );
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
        if( ! canParse() ) return new TimeStampEmpty();

        return TimeStamp.create( this );
    }

    public boolean canParse() throws ParseException
    {
        return TimeStamp.canParse( this );
    }
}
