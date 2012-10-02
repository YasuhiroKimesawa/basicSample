package jp.pilgrim_ericclapton.model.primitive.date;

import java.text.ParseException;
import java.util.Date;

import jp.pilgrim_ericclapton.model.primitive.date.format.TimeStampFormat;

import org.apache.commons.lang.time.DateUtils;

public class TimeStampParsing
{
    private static TimeStampParsing instance;

    private static String[] formats = { "yyyy/MM/dd kk:mm" };

    private final String timeStamp;

    public static TimeStampParsing instansOf( TimeStampFormat timeStampFormat )
    {
        if( instance == null )
        {
            return new TimeStampParsing( timeStampFormat );
        }

        return instance;
    }

    private TimeStampParsing( TimeStampFormat timeStamp )
    {
        this.timeStamp =  timeStamp.timeStampAsText();
    }

    public boolean canParse()
    {
        try
        {
            DateUtils.parseDateStrictly( timeStamp, formats );
        }
        catch ( ParseException parseException )
        {
            return false;
        }

        return true;
    }

    public Date parse() throws ParseException
    {
        return DateUtils.parseDateStrictly( timeStamp, formats );
    }
}
