package jp.pilgrim_ericclapton.model.primitive.date;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

import jp.pilgrim_ericclapton.model.primitive.date.format.DateStampFormat;

class DateStampParsing
{
    private static String[] formats = { "yyyy/MM/dd" };

    private final String dateStamp;

    public DateStampParsing( DateStampFormat dateStampFormat )
    {
        this.dateStamp = String.format( "%s", dateStampFormat.getDateStamp() );
    }

    public boolean canParse()
    {
        try
        {
            DateUtils.parseDateStrictly( dateStamp, formats );
        }
        catch ( ParseException parseException )
        {
            return false;
        }

        return true;
    }

    public Date parse() throws ParseException
    {
        return DateUtils.parseDateStrictly( dateStamp, formats );
    }

}
