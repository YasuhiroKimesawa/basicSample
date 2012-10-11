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

        assertFalse( DateStampParsing.canParse( dateStampFormat ) );
    }

    @Test
    public void 日付でない場合はfalse()
    {
        DateStampFormat dateStampFormat = new DateStampFormat( "2011/02/aあ" );

        assertFalse( DateStampParsing.canParse( dateStampFormat ) );
    }

    @Test
    public void 日付の場合はtrue()
    {
        DateStampFormat dateStampFormat = new DateStampFormat( "2011/02/11" );

        assertTrue( DateStampParsing.canParse( dateStampFormat ) );
    }

    @Test
    public void 日付でない場合はparseできる() throws ParseException
    {
        DateStampFormat dateStampFormat = new DateStampFormat( "2011/02/11" );

        assertThat( DateStampParsing.parse( dateStampFormat ).getClass().getName(), is( new Date().getClass().getName() ) );
    }

}
