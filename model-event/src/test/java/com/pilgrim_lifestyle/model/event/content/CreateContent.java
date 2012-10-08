package com.pilgrim_lifestyle.model.event.content;

import java.util.Map;

import com.pilgrim_lifestyle.model.event.EventData;

public class CreateContent
{
    public static Content createContent( Map<EventData.Data, String> eventData )
    {
        Explanation explanation = CreateContent.createExplanation( eventData );

        HeadCount headCount = createHeadCount( eventData );

        return new Content( headCount, explanation );
    }

    public static Explanation createExplanation( Map<EventData.Data, String> eventData )
    {
        String explanation = eventData.get( EventData.Data.EXPLANATION );

        return new Explanation( explanation );
    }

    public static HeadCount createHeadCount( Map<EventData.Data, String> eventData )
    {
        String headCount = eventData.get( EventData.Data.HeadCount );

        return new HeadCount( headCount );
    }
}
