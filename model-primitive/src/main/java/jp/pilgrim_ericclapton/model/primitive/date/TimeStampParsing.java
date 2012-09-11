package jp.pilgrim_ericclapton.model.primitive.date;

import java.text.ParseException;
import java.util.Date;

import jp.pilgrim_ericclapton.model.primitive.date.format.TimeStampFormat;

import org.apache.commons.lang.time.DateUtils;

class TimeStampParsing
{
    private static String[] formats = { "yyyy/MM/dd kk:mm" };

    private final String timeStamp;

    public TimeStampParsing( TimeStampFormat timeStamp )
    {
        this.timeStamp =  String.format( "%s %s", timeStamp.dateStampAsText(), timeStamp.hourMinuteAsText() );
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
