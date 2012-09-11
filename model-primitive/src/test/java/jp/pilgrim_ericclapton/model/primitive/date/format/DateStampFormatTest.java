package jp.pilgrim_ericclapton.model.primitive.date.format;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import org.junit.Test;

public class DateStampFormatTest
{
    @Test
    public void 今日より前ならtrue() throws ParseException
    {
        String tommorow = plusFromTodayDate( 1 );
        DateStampFormat dateStampFormat = new DateStampFormat( tommorow );

        assertTrue( dateStampFormat.afterToday() );
    }

    @Test
    public void 今日ならfalse() throws ParseException
    {
        String tommorow = plusFromTodayDate( 0 );
        DateStampFormat dateStampFormat = new DateStampFormat( tommorow );

        assertFalse( dateStampFormat.afterToday() );
    }

    private String plusFromTodayDate( int plus )
    {
        Calendar calendar = Calendar.getInstance( Locale.JAPAN );
        calendar.add( Calendar.DAY_OF_MONTH, plus );

        return new SimpleDateFormat( "yyyy/MM/dd", Locale.JAPANESE ).format( calendar.getTime() );
    }

}
