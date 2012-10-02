package jp.pilgrim_ericclapton.model.primitive.date.range;

import java.text.ParseException;

import jp.pilgrim_ericclapton.model.primitive.date.TimeStamp;
import jp.pilgrim_ericclapton.model.primitive.date.format.TimeStampFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TimeStampRange
{
    private TimeStampFormat startTimeStampFormat;

    private TimeStampFormat endTimeStampFormat;

    private static TimeStampRange instance;

    public static TimeStampRange instanceOf(  TimeStampFormat startTimeStampFormat, TimeStampFormat endTimeStampFormat  )
    {
        if( instance == null )
        {
            return new TimeStampRange( startTimeStampFormat, endTimeStampFormat );
        }

        return instance;
    }

    private TimeStampRange( TimeStampFormat startTimeStampFormat, TimeStampFormat endTimeStampFormat )
    {
        this.startTimeStampFormat = startTimeStampFormat;
        this.endTimeStampFormat = endTimeStampFormat;
    }

    public boolean isCollect() throws ParseException
    {
        TimeStamp start = TimeStamp.instanceOf( startTimeStampFormat );

        TimeStamp end = TimeStamp.instanceOf( endTimeStampFormat );

        return start.before( end );
    }

}
