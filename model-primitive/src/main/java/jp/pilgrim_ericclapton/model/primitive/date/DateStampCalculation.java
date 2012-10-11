package jp.pilgrim_ericclapton.model.primitive.date;

import java.text.ParseException;
import java.util.Date;

import jp.pilgrim_ericclapton.model.primitive.date.format.DateStampFormat;

import org.joda.time.DateTime;

public class DateStampCalculation
{
    private Date date;

    public boolean isAfterToday()
    {
        Date today = new Date();

        return date.after( today );
    }

    public DateStamp plus( int amount ) throws ParseException
    {
        DateTime dateTime = new DateTime( date );

        DateTime plusedDateTime = dateTime.plusDays( amount );

        return DateStamp.create( new DateStampFormat( plusedDateTime.toString() ) );
    }

    public DateStamp minus( int amount ) throws ParseException
    {
        DateTime dateTime = new DateTime( date );

        DateTime minusedDateTime = dateTime.minusDays( amount );

        return DateStamp.create( new DateStampFormat( minusedDateTime.toString() ) );
    }
}
