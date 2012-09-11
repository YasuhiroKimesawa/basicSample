package jp.pilgrim_ericclapton.model.primitive.date;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.text.ParseException;
import java.util.Date;

import jp.pilgrim_ericclapton.model.primitive.date.format.DateStampFormat;

import org.junit.Test;

public class DateStampParsingTest
{

    @Test
    public void 不正な日付はfalse()
    {
        DateStampFormat dateStampFormat = new DateStampFormat( "2011/02/52" );

        DateStampParsing dateStampParsing = new DateStampParsing( dateStampFormat );

        assertFalse( dateStampParsing.canParse() );
    }

    @Test
    public void 日付でない場合はfalse()
    {
        DateStampFormat dateStampFormat = new DateStampFormat( "2011/02/aあ" );

        DateStampParsing dateStampParsing = new DateStampParsing( dateStampFormat );

        assertFalse( dateStampParsing.canParse() );
    }

    @Test
    public void 日付の場合はtrue()
    {
        DateStampFormat dateStampFormat = new DateStampFormat( "2011/02/11" );

        DateStampParsing dateStampParsing = new DateStampParsing( dateStampFormat );

        assertTrue( dateStampParsing.canParse() );
    }

    @Test
    public void 日付でない場合はparseできる() throws ParseException
    {
        DateStampFormat dateStampFormat = new DateStampFormat( "2011/02/11" );

        DateStampParsing dateStampParsing = new DateStampParsing( dateStampFormat );

        assertThat( dateStampParsing.parse().getClass().getName(), is( new Date().getClass().getName() ) );
    }

}
