package jp.pilgrim_ericclapton.model.primitive.date;

import java.text.ParseException;
import java.util.Date;

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

    public boolean afterToday()
    {
        Date today = new Date();

        return date.after( today );
    }
}
