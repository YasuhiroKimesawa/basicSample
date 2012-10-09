package com.pilgrim_lifestyle.model.event.content;

import java.util.Map;

import org.junit.Test;

import com.pilgrim_lifestyle.model.event.EventData;
import com.systemsekkei.base.test.model.BaseModelTest;

public class ContentTest extends BaseModelTest<Content>
{
    private final Map<EventData.Data, String> eventData = new EventData().getData();

    private Content content = null;

    @Test
    public void validationが実行される()
    {
        eventData.put( EventData.Data.HeadCount, "" );
        eventData.put( EventData.Data.EXPLANATION, "" );

        content = CreateContent.createContent( eventData );

        validateAndAssertCount( 2, content );
    }

}
