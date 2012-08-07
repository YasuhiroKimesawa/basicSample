package com.pilgrim_lifestyle.model.eventer;

public interface EventerRepository
{
    Integer nextId();

    void add( Eventer eventer );
}
