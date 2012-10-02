package jp.pilgrim_ericclapton.model.primitive.date;

import jp.pilgrim_ericclapton.model.primitive.date.format.TimeStampFormat;

import java.text.ParseException;
import java.util.Date;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TimeStamp
{
    private static TimeStamp instance;

    private Date date;

    public static TimeStamp instanceOf( TimeStampFormat timeStampFormat ) throws ParseException
    {
        TimeStampParsing parsing = TimeStampParsing.instansOf( timeStampFormat );
        if( ! parsing.canParse() )
        {
            return new TimeStampEmpty();
        }

        if( instance == null )
        {
            return new TimeStamp( timeStampFormat );
        }

        return instance;
    }

    private TimeStamp( TimeStampFormat timeStampFormat ) throws ParseException
    {
        TimeStampParsing parsing = TimeStampParsing.instansOf( timeStampFormat );

        date = parsing.parse();
    }

//    public static boolean canParse( TimeStampFormat timeStampFormat )
//    {
//        TimeStampParsing parsing = TimeStampParsing.instansOf( timeStampFormat );
//
//        return parsing.canParse();
//    }

    public boolean before( TimeStamp timeStamp )
    {
        return date.before( timeStamp.date );
    }

}
