package com.pilgrim_lifestyle.model.event.period;

import java.util.Map;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;

import jp.pilgrim_ericclapton.model.primitive.date.DateStamp;

import org.junit.Test;

import com.pilgrim_lifestyle.model.event.EventData;
import com.systemsekkei.base.test.model.BaseModelTest;

public class DateOfTest extends BaseModelTest<DateOf>
{
    private final Map<EventData.Data, String> eventData = new EventData().getData();

    private DateOf dateOf;

    @Test
    public void 今日含み前だとエラー()
    {
        DateStamp today = DateStamp.today();
        eventData.put( EventData.Data.DATEOF_DATE, today.toFormat().toString() );

        dateOf = CreatePeriod.createDateOf( eventData );

        validateAndAssert( "afterToday", AssertTrue.class, dateOf );
    }

    @Test
    public void 日付が不正だとエラー()
    {
        eventData.put( EventData.Data.DATEOF_DATE, "2022/01/51" );
        dateOf = CreatePeriod.createDateOf( eventData );

        validateAndAssert( "collectFormat", AssertTrue.class, dateOf );
    }

    @Test
    public void emptyだとエラー()
    {
        eventData.put( EventData.Data.DATEOF_DATE, "" );
        dateOf = CreatePeriod.createDateOf( eventData );

        validateAndAssert( "empty", AssertFalse.class, dateOf );
    }

}
