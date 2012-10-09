package com.pilgrim_lifestyle.model.event.content;

import com.pilgrim_lifestyle.model.event.EventData;

import java.util.Map;

import org.hibernate.validator.constraints.NotEmpty;
import org.junit.Test;

import com.systemsekkei.base.test.model.BaseModelTest;

public class ExplanationTest extends BaseModelTest<Explanation>
{
    private final Map<EventData.Data, String> eventData = new EventData().getData();

    private Explanation explanation;

    @Test
    public void emptyの場合はエラー()
    {
        eventData.put( EventData.Data.EXPLANATION, "" );

        explanation = CreateContent.createExplanation( eventData );

        validateAndAssert( "explanation", NotEmpty.class, explanation );
    }

}
