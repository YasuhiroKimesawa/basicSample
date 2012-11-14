package com.pilgrim_lifestyle.model.event;

import com.pilgrim_lifestyle.model.event.summary.EventSummaries;
import com.pilgrim_lifestyle.model.event.summary.EventSummary;

public interface EventRepository
{
    Integer nextId();

    void register( Event event );

    EventSummaries list();

    EventSummary selectById( Integer id );
}
