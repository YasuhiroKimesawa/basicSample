package jp.pilgrim_ericclapton.model.primitive.date;

import jp.pilgrim_ericclapton.model.primitive.date.format.TimeStampFormat;

import java.text.ParseException;
import java.util.Date;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TimeStamp
{
    private Date date;

    public static TimeStamp create( TimeStampFormat timeStampFormat ) throws ParseException
    {
        TimeStampParsing parsing = new TimeStampParsing( timeStampFormat );
        if( ! parsing.canParse() )
        {
            return new TimeStampEmpty();
        }

        return new TimeStamp( timeStampFormat );
    }

    private TimeStamp( TimeStampFormat timeStampFormat ) throws ParseException
    {
        TimeStampParsing parsing = new TimeStampParsing( timeStampFormat );

        date = parsing.parse();
    }

    public static boolean canParse( TimeStampFormat timeStampFormat )
    {
        TimeStampParsing parsing = new TimeStampParsing( timeStampFormat );

        return parsing.canParse();
    }

    public boolean before( TimeStamp timeStamp )
    {
        return date.before( timeStamp.date );
    }

}
