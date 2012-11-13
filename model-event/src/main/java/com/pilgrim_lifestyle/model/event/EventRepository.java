package com.pilgrim_lifestyle.model.event;

import com.pilgrim_lifestyle.model.event.summary.EventSummaries;

public interface EventRepository
{
    Integer nextId();

    void register( Event event );

    EventSummaries list();
}
