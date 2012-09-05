package jp.pilgrim_ericclapton.model.primitive.date;

import java.text.ParseException;
import java.util.Date;

import lombok.NoArgsConstructor;

import org.apache.commons.lang.time.DateUtils;

@NoArgsConstructor
public class TimeStamp
{
    private Date date;

    public static TimeStamp create( DateStamp dateStamp, HourAndMinute hourAndMinute ) throws ParseException
    {
        if( dateStamp.isEmpty() )
        {
            return new TimeStampEmpty();
        }

        return new TimeStamp( dateStamp, hourAndMinute );
    }

    private TimeStamp( DateStamp dateStamp, HourAndMinute hourAndMinute ) throws ParseException
    {
        String[] formats = { "yyyy/mm/dd HH:mm" };

        String text = String.format( "%s %s", dateStamp.asText(), hourAndMinute.asText() );

        date = DateUtils.parseDateStrictly( text, formats );
    }

    public boolean before( TimeStamp timeStamp )
    {
        return date.before( timeStamp.date );
    }

}
