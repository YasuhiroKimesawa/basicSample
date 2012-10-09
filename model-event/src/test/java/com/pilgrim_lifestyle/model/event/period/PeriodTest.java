package com.pilgrim_lifestyle.model.event.period;

import com.pilgrim_lifestyle.model.event.EventData;
import jp.pilgrim_ericclapton.model.primitive.date.DateStamp;

import java.util.Map;

import javax.validation.constraints.AssertTrue;

import org.junit.Test;

import com.systemsekkei.base.test.model.BaseModelTest;

public class PeriodTest extends BaseModelTest<Period>
{
    private final Map<EventData.Data, String> eventData = new EventData().getData();

    private Period period;

    @Test
    public void 応募終了日よりイベント日時が前だとエラー()
    {
        DateStamp tomorrow = DateStamp.tomorrow();
        eventData.put( EventData.Data.DATEOF_DATE, tomorrow.toFormat().toString() );

        DateStamp tenDaysAfter = tomorrow.plus( 10 );
        eventData.put( EventData.Data.APPLICATION_DATE_RANGE_END_DATE, tenDaysAfter.toFormat().toString() );

        period = CreatePeriod.createPeriod( eventData );

        validateAndAssert( "collect", AssertTrue.class, period );
    }

}
