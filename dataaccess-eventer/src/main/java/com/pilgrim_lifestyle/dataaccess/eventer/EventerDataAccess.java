package com.pilgrim_lifestyle.dataaccess.eventer;

import com.pilgrim_lifestyle.model.eventer.Eventer;
import com.pilgrim_lifestyle.model.eventer.EventerRepository;

import org.springframework.stereotype.Repository;


@Repository( "eventerRepository" )
public class EventerDataAccess implements EventerRepository
{

    @Override
    public void add( Eventer eventer )
    {
        return;
    }

}
