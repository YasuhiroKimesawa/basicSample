package jp.pilgrim_ericclapton.model.primitive.date;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.text.ParseException;

import jp.pilgrim_ericclapton.model.primitive.date.format.DateStampFormat;
import jp.pilgrim_ericclapton.model.primitive.date.format.HourMinuteFormat;
import jp.pilgrim_ericclapton.model.primitive.date.format.TimeStampFormat;

import org.junit.Test;

public class TimeStampTest
{
    private TimeStamp create( String date, String hour ) throws ParseException
    {
        DateStampFormat dateStampFormat = new DateStampFormat( date );
        HourMinuteFormat hourMinuteFormat = new HourMinuteFormat( hour );
        TimeStampFormat timeStampFormat = new TimeStampFormat( dateStampFormat, hourMinuteFormat );

        return TimeStamp.create( timeStampFormat );
    }

    @Test
    public void 変換できない日付はEmpty() throws ParseException
    {
        TimeStamp timeStamp = create( "2011/01/01", "26:12" );

        assertThat( TimeStampEmpty.class.toString(), is( timeStamp.getClass().toString() ) );
    }

    @Test
    public void 不正な日付はEmpty() throws ParseException
    {
        TimeStamp timeStamp = create( "2011/02/31", "20:12" );

        assertThat( TimeStampEmpty.class.toString(), is( timeStamp.getClass().toString() ) );
    }

    @Test
    public void AよりBの方がが前の日付はtrue() throws ParseException
    {
        TimeStamp A = create( "2011/02/01", "20:12" );
        TimeStamp B = create( "2011/01/01", "20:12" );

        assertTrue( B.before( A ) );
    }

    @Test
    public void AとBが同じ日付はfalse() throws ParseException
    {
        TimeStamp A = create( "2011/02/01", "20:12" );
        TimeStamp B = create( "2011/02/01", "20:12" );

        assertFalse( B.before( A ) );
    }

}
