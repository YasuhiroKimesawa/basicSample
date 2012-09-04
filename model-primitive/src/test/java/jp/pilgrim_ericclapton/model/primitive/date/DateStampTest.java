package jp.pilgrim_ericclapton.model.primitive.date;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;

@RunWith( Enclosed.class )
public class DateStampTest
{
    public static class beforeTest
    {
        DateStamp dateStamp;

        @Before
        public void setup()
        {
            Calendar calendar = Calendar.getInstance( Locale.JAPAN );
            calendar.set( 2010, 1, 1 );
            Date date = calendar.getTime();
            dateStamp = new DateStamp( date );
        }

        @Test
        public void test()
        {
            Date date = new Date();
            DateStamp dateStamp2 = new DateStamp( date );

            assertThat( dateStamp.before( dateStamp2 ), is( true ) );
        }
    }

    public static class test
    {
        DateStamp dateStamp;

        ConversionService conversionService;

        @Before
        public void setup()
        {
            FormattingConversionServiceFactoryBean factoryBean = new FormattingConversionServiceFactoryBean();
            factoryBean.afterPropertiesSet();
            conversionService = factoryBean.getObject();
        }

        @Test
        public void tests()
        {
            Date donattel = (Date)conversionService.convert( "2011/013s/13", Date.class );
            assertThat( donattel, is( (Date)null ) );
        }
    }

}
