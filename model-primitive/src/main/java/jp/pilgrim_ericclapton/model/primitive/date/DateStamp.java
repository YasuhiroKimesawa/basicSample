package jp.pilgrim_ericclapton.model.primitive.date;

import java.text.ParseException;
import java.util.Date;

import org.joda.time.DateTime;

import jp.pilgrim_ericclapton.model.primitive.date.format.DateStampFormat;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DateStamp
{
    private Date date;

    private DateStamp( DateStampFormat dateStampFormat ) throws ParseException
    {
        DateStampParsing parsing = new DateStampParsing( dateStampFormat );

        date = parsing.parse();
    }

    public static DateStamp create( DateStampFormat dateStampFormat ) throws ParseException
    {
        DateStampParsing parsing = new DateStampParsing( dateStampFormat );
        if( ! parsing.canParse() )
        {
            return new DateStampEmpty();
        }

        return new DateStamp( dateStampFormat );
    }

    private DateStamp( Date date )
    {
        this.date = date;
    }

    public static DateStamp today()
    {
        Date date = new Date();
        return new DateStamp( date );
    }

    public static DateStamp tomorrow()
    {
        return DateStamp.today().plus( 1 );
    }

    public boolean isAfterToday()
    {
        Date today = new Date();

        return date.after( today );
    }

    public DateStamp plus( int amount )
    {
        DateTime dateTime = new DateTime( date );

        DateTime plusedDateTime = dateTime.plusDays( amount );

        return new DateStamp( plusedDateTime.toDate() );
    }

    public DateStamp minus( int amount )
    {
        DateTime dateTime = new DateTime( date );

        DateTime minusedDateTime = dateTime.minusDays( amount );

        return new DateStamp( minusedDateTime.toDate() );
    }

    public DateStampFormat toFormat()
    {
        DateTime dateTime = new DateTime( date );

        return new DateStampFormat( dateTime.toString( "yyyy/MM/dd" ) );
    }
}
