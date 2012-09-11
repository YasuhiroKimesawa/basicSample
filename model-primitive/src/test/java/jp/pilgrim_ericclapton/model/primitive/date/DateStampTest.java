package jp.pilgrim_ericclapton.model.primitive.date;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import jp.pilgrim_ericclapton.model.primitive.date.format.DateStampFormat;

import org.junit.Test;

public class DateStampTest
{
    private DateStamp createDateFormat( String dateFormat ) throws ParseException
    {
        DateStampFormat format = new DateStampFormat( dateFormat );

        return DateStamp.create( format );
    }

    @Test
    public void 変換できない日付はEmpty() throws ParseException
    {
        DateStamp dateStamp = createDateFormat( "2012/02/30" );

        assertThat( DateStampEmpty.class.toString(), equalTo( dateStamp.getClass().toString() ) );
    }

    @Test
    public void 不正な日付はEmpty() throws ParseException
    {
        DateStamp dateStamp = createDateFormat( "2012/02/aa" );

        assertThat( DateStampEmpty.class.toString(), equalTo( dateStamp.getClass().toString() ) );
    }

    @Test
    public void 今日以降はtrue() throws ParseException
    {
        DateStamp dateStamp = createDateFormat( plusFromTodayDate( 1 ) );

        assertTrue( dateStamp.afterToday() );
    }

    @Test
    public void 今日はfalse() throws ParseException
    {
        DateStamp dateStamp = createDateFormat( plusFromTodayDate( 0 ) );

        assertFalse( dateStamp.afterToday() );
    }

    private String plusFromTodayDate( int plus )
    {
        Calendar calendar = Calendar.getInstance( Locale.JAPAN );
        calendar.add( Calendar.DAY_OF_MONTH, plus );

        return new SimpleDateFormat( "yyyy/MM/dd", Locale.JAPANESE ).format( calendar.getTime() );
    }

}
