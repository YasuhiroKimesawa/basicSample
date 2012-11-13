package com.pilgrim_lifestyle.model.event.summary;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EventSummaries
{
    private List<EventSummary> list;

    public EventSummaries( List<EventSummary> list )
    {
        this.list = list;
    }


}
