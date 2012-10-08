package com.pilgrim_lifestyle.model.event.period;

import jp.pilgrim_ericclapton.model.primitive.date.format.DateStampFormat;
import jp.pilgrim_ericclapton.model.primitive.date.format.HourMinuteFormat;
import jp.pilgrim_ericclapton.model.primitive.date.format.TimeStampFormat;

import com.pilgrim_lifestyle.model.event.EventData;

import java.util.Map;

public class CreatePeriod
{
    public static Period createPeriod( Map<EventData.Data, String> eventData )
    {
        DateOf dateOf = createDateOf( eventData );
        ApplicantDateRange applicantDateRange = createApplicantDateRange( eventData );

        return new Period( dateOf, applicantDateRange );
    }

    public static DateOf createDateOf( Map<EventData.Data, String> eventData )
    {
        String dateOfDate = eventData.get( EventData.Data.DATEOF_DATE );
        String dateOfTime = eventData.get( EventData.Data.DATEOF_TIME );
        TimeStampFormat timeStampFormat = createTimeStampFormat( dateOfDate, dateOfTime);

        if( timeStampFormat == null ) return null;

        return new DateOf( timeStampFormat );
    }

    public static ApplicantDateRange createApplicantDateRange( Map<EventData.Data, String> eventData )
    {
        String startDate = eventData.get( EventData.Data.APPLICATION_DATE_RANGE_START_DATE );
        String startTime = eventData.get( EventData.Data.APPLICATION_DATE_RANGE_START_TIME );
        TimeStampFormat start = createTimeStampFormat( startDate, startTime );

        String endDate = eventData.get( EventData.Data.APPLICATION_DATE_RANGE_END_DATE );
        String endTime = eventData.get( EventData.Data.APPLICATION_DATE_RANGE_END_TIME );
        TimeStampFormat end = createTimeStampFormat( endDate, endTime );

        return new ApplicantDateRange( start, end );
    }

    private static TimeStampFormat createTimeStampFormat( String date, String time )
    {
        DateStampFormat dateStampFormat = new DateStampFormat( date );
        HourMinuteFormat hourMinuteFormat = new HourMinuteFormat( time );

        return new TimeStampFormat( dateStampFormat, hourMinuteFormat );
    }
}
