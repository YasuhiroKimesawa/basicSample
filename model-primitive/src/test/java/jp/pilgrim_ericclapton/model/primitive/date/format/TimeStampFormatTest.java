package jp.pilgrim_ericclapton.model.primitive.date.format;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.text.ParseException;

import jp.pilgrim_ericclapton.model.primitive.date.TimeStampEmpty;

import org.junit.Test;

public class TimeStampFormatTest
{

    @Test
    public void parseできない場合はempty() throws ParseException
    {
        DateStampFormat dateStampFormat = new DateStampFormat( "2012/02/31" );
        HourMinuteFormat hourMinuteFormat = new HourMinuteFormat( "10:00" );
        TimeStampFormat timeStampFormat = new TimeStampFormat( dateStampFormat, hourMinuteFormat );

        assertThat( timeStampFormat.getTimeStamp().getClass().getName(), is( new TimeStampEmpty().getClass().getName() ) );
    }

}
