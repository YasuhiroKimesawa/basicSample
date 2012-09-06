package jp.pilgrim_ericclapton.model.primitive.date;

import jp.pilgrim_ericclapton.model.primitive.date.format.TimeStampFormat;

import java.text.ParseException;
import java.util.Date;

import lombok.NoArgsConstructor;

import org.apache.commons.lang.time.DateUtils;

@NoArgsConstructor
public class TimeStamp
{
    private Date date;

    public static TimeStamp create( TimeStampFormat timeStampFormat ) throws ParseException
    {
        if( timeStampFormat.isEmpty() )
        {
            return new TimeStampEmpty();
        }

        return new TimeStamp( timeStampFormat );
    }

    private TimeStamp( TimeStampFormat timeStampFormat ) throws ParseException
    {
        String[] formats = { "yyyy/mm/dd HH:mm" };

        String text = String.format( "%s %s", timeStampFormat.dateStampAsText(), timeStampFormat.hourMinuteAsText() );

        date = DateUtils.parseDateStrictly( text, formats );
    }

    public boolean before( TimeStamp timeStamp )
    {
        return date.before( timeStamp.date );
    }

}
