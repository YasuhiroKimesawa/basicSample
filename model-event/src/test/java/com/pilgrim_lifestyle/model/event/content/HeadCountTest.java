package com.pilgrim_lifestyle.model.event.content;

import com.pilgrim_lifestyle.model.event.EventData;

import java.util.Map;

import org.hibernate.validator.constraints.NotEmpty;
import org.junit.Test;

import com.systemsekkei.base.test.model.BaseModelTest;

public class HeadCountTest extends BaseModelTest<HeadCount>
{
    private final Map<EventData.Data, String> eventData = new EventData().getData();

    HeadCount headCount;

    @Test
    public void emptyの場合はエラー()
    {
        eventData.put( EventData.Data.HeadCount, "" );

        headCount = CreateContent.createHeadCount( eventData );

        validateAndAssert( "headCount", NotEmpty.class, headCount );
    }

}
