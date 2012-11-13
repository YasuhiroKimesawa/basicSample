package com.pilgrim_lifestyle.model.event.summary;

import com.pilgrim_lifestyle.model.event.content.Content;
import com.pilgrim_lifestyle.model.event.period.Period;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EventSummaryDetail
{
    private Period period;

    private Content content;

    public EventSummaryDetail( Period period, Content content )
    {
        this.period = period;
        this.content = content;
    }
}
