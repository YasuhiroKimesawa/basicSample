package com.pilgrim_lifestyle.model.event.summary;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EventSummary
{
    private Integer id;

    private String name;

    private EventSummaryDetail eventSummaryDetail;

    public EventSummary( Integer id, String name, EventSummaryDetail eventSummaryDetail )
    {
        this.id = id;
        this.name = name;
        this.eventSummaryDetail = eventSummaryDetail;
    }


}
