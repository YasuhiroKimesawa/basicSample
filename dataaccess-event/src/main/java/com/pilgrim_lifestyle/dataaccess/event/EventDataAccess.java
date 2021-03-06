package com.pilgrim_lifestyle.dataaccess.event;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pilgrim_lifestyle.model.event.Event;
import com.pilgrim_lifestyle.model.event.EventRepository;
import com.pilgrim_lifestyle.model.event.summary.EventSummaries;
import com.pilgrim_lifestyle.model.event.summary.EventSummary;
import com.pilgrim_lifestyle.security.model.AccountUserHelper;

@Repository( "eventRepository" )
public class EventDataAccess implements EventRepository
{
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public Integer nextId()
    {
        return sqlSessionTemplate.selectOne( getClass().getName() + ".nextId" );
    }

    @Override
    public void register( Event event )
    {
        Integer accountId = AccountUserHelper.getLoginUser().getId();

        Map<String, Object> parameterMap = new HashMap<String, Object>();
        parameterMap.put( "accountId", accountId );
        parameterMap.put( "event", event );

        sqlSessionTemplate.insert( getClass().getName() + ".insert", parameterMap );
    }

    @Override
    public EventSummaries list()
    {
        List<EventSummary> list = sqlSessionTemplate.selectList( getClass().getName() + ".list" );

        return new EventSummaries( list );
    }

    @Override
    public EventSummary selectById( Integer id )
    {
        return sqlSessionTemplate.selectOne( getClass().getName() + ".selectById", id );
    }

}
