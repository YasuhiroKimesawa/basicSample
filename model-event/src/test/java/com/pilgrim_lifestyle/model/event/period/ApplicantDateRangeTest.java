package com.pilgrim_lifestyle.model.event.period;

import com.pilgrim_lifestyle.model.event.EventData;

import java.text.ParseException;
import java.util.Map;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;

import jp.pilgrim_ericclapton.model.primitive.date.DateStamp;

import org.junit.Test;


import com.systemsekkei.base.test.model.BaseModelTest;

public class ApplicantDateRangeTest extends BaseModelTest<ApplicantDateRange>
{
    private final Map<EventData.Data, String> eventData = new EventData().getData();

    private ApplicantDateRange applicantDateRange;

    @Test
    public void 終了日が開始日より前だとエラー() throws ParseException
    {
        DateStamp tomorrow = DateStamp.tomorrow();
        eventData.put( EventData.Data.APPLICATION_DATE_RANGE_END_DATE, tomorrow.toFormat().toString() );

        DateStamp tenDaysAfter = tomorrow.plus( 10 );
        eventData.put( EventData.Data.APPLICATION_DATE_RANGE_START_DATE, tenDaysAfter.toFormat().toString() );

        applicantDateRange = CreatePeriod.createApplicantDateRange( eventData );

        validateAndAssert( "collect", AssertTrue.class, applicantDateRange );
    }

    @Test
    public void 終了日が今日含み前だとエラー() throws ParseException
    {
        DateStamp today = DateStamp.today();
        eventData.put( EventData.Data.APPLICATION_DATE_RANGE_END_DATE, today.toFormat().toString() );

        DateStamp tenDaysAfter = today.minus( 10 );
        eventData.put( EventData.Data.APPLICATION_DATE_RANGE_START_DATE, tenDaysAfter.toFormat().toString() );

        applicantDateRange = CreatePeriod.createApplicantDateRange( eventData );

        validateAndAssert( "afterToday", AssertTrue.class, applicantDateRange );
    }

    @Test
    public void 開始日か終了日がemptyだとエラー() throws ParseException
    {
        eventData.put( EventData.Data.APPLICATION_DATE_RANGE_START_DATE, "" );

        applicantDateRange = CreatePeriod.createApplicantDateRange( eventData );

        validateAndAssert( "empty", AssertFalse.class, applicantDateRange );
    }

}
