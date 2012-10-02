package com.pilgrim_lifestyle.model.event;

import javax.validation.Valid;

import com.pilgrim_lifestyle.model.event.content.Content;
import com.pilgrim_lifestyle.model.event.period.Period;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EventDetail
{
    @Valid
    private Period period;

    @Valid
    private Content content;

    public EventDetail( Period period, Content content )
    {
        this.period = period;
        this.content = content;
    }

    public static EventDetail draft()
    {
        Period period = Period.draft();
        Content content = Content.draft();

        return new EventDetail( period, content );
    }

}
