package com.pilgrim_lifestyle.dataaccess.eventer;

import com.pilgrim_lifestyle.model.eventer.Eventer;
import com.pilgrim_lifestyle.model.eventer.EventerRepository;
import com.pilgrim_lifestyle.table.eventer.EventerTable;
import com.pilgrim_lifestyle.table.eventer.EventerTableDxo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository( "eventerRepository" )
public class EventerDataAccess implements EventerRepository
{
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    EventerTableDxo eventerTableDxo;

    @Override
    public Integer nextId()
    {
        return sqlSessionTemplate.selectOne( this.getClass().getName() + ".nextId" );
    }

    @Override
    public void add( Eventer eventer )
    {
        EventerTable eventerTable = eventerTableDxo.toDto( eventer );

        sqlSessionTemplate.insert( this.getClass().getName() + ".save", eventerTable );
        sqlSessionTemplate.insert( this.getClass().getName() + ".savePassword", eventerTable );
    }

    @Override
    public boolean isEmailExist( Eventer eventer )
    {
        EventerTable eventerTable = eventerTableDxo.toDto( eventer );
        int countEmail = ( Integer )sqlSessionTemplate.selectOne( this.getClass().getName() + ".countEmail", eventerTable );

        if( countEmail == 0 ) return false;

        return true;
    }

}
