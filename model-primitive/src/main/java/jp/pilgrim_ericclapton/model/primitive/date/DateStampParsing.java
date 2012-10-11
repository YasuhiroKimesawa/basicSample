package jp.pilgrim_ericclapton.model.primitive.date;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

import jp.pilgrim_ericclapton.model.primitive.date.format.DateStampFormat;

class DateStampParsing
{
    private static String[] formats = { "yyyy/MM/dd" };

    public static boolean canParse( DateStampFormat dateStampFormat )
    {
        try
        {
            DateUtils.parseDateStrictly( dateStampFormat.toString(), formats );
        }
        catch ( ParseException parseException )
        {
            return false;
        }

        return true;
    }

    public static Date parse( DateStampFormat dateStampFormat ) throws ParseException
    {
        return DateUtils.parseDateStrictly( dateStampFormat.toString(), formats );
    }

}
