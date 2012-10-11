package jp.pilgrim_ericclapton.model.primitive.date;

import java.text.ParseException;
import java.util.Date;

import jp.pilgrim_ericclapton.model.primitive.date.format.TimeStampFormat;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TimeStamp
{
    private Date date;

    private TimeStamp( TimeStampFormat timeStampFormat ) throws ParseException
    {
        this.date = TimeStampParsing.parse( timeStampFormat );
    }

    public static TimeStamp create( TimeStampFormat timeStampFormat ) throws ParseException
    {
        if( ! TimeStampParsing.canParse( timeStampFormat ) )
        {
            return new TimeStampEmpty();
        }

        return new TimeStamp( timeStampFormat );
    }

    public boolean before( TimeStamp timeStamp )
    {
        return date.before( timeStamp.date );
    }

    public Date toDate()
    {
        return date;
    }

}
