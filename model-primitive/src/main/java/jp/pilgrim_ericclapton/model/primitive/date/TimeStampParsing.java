package jp.pilgrim_ericclapton.model.primitive.date;

import java.text.ParseException;
import java.util.Date;

import jp.pilgrim_ericclapton.model.primitive.date.format.TimeStampFormat;

import org.apache.commons.lang.time.DateUtils;

public class TimeStampParsing
{
    private static String[] formats = { "yyyy/MM/dd kk:mm" };

    public static boolean canParse( TimeStampFormat timeStampFormat )
    {
        try
        {
            DateUtils.parseDateStrictly( timeStampFormat.toString(), formats );
        }
        catch ( ParseException parseException )
        {
            return false;
        }

        return true;
    }

    public static Date parse( TimeStampFormat timeStampFormat ) throws ParseException
    {
        return DateUtils.parseDateStrictly( timeStampFormat.toString(), formats );
    }
}
