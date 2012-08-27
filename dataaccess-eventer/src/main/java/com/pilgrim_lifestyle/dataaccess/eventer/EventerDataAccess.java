package com.pilgrim_lifestyle.dataaccess.eventer;

import com.pilgrim_lifestyle.model.eventer.Eventer;
import com.pilgrim_lifestyle.model.eventer.EventerRepository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository( "eventerRepository" )
public class EventerDataAccess implements EventerRepository
{
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public Integer nextId()
    {
        return sqlSessionTemplate.selectOne( this.getClass().getName() + ".nextId" );
    }

    @Override
    public void add( Eventer eventer )
    {
        sqlSessionTemplate.insert( this.getClass().getName() + ".save", eventer );

        sqlSessionTemplate.insert( this.getClass().getName() + ".savePassword", eventer );
    }

    @Override
    public boolean isEmailExist( Eventer eventer )
    {
        int countEmail = ( Integer )sqlSessionTemplate.selectOne( this.getClass().getName() + ".countEmail", eventer );

        if( countEmail == 0 ) return false;

        return true;
    }

}
