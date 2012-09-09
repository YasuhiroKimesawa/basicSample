package com.pilgrim_lifestyle.model.event;

public interface EventRepository
{
    public Integer nextId();

    public void register( Event event );
}
