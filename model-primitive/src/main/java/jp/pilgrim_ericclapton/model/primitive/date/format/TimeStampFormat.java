package jp.pilgrim_ericclapton.model.primitive.date.format;

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
        String dateStampAsText = dateStamp.getDateStamp();

        String hourMinuteAsText = hourMinute.getHourMinute();

        return String.format( "%s %s", dateStampAsText,  hourMinuteAsText );
    }

}
