package com.pilgrim_lifestyle.dataaccess.account;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pilgrim_lifestyle.model.account.Account;
import com.pilgrim_lifestyle.model.account.AccountRepository;

@Repository( "accountRepository" )
public class AccountDataAccess implements AccountRepository
{
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public Integer nextId()
    {
        return sqlSessionTemplate.selectOne( this.getClass().getName() + ".nextId" );
    }

    @Override
    public void add( Account account )
    {
        sqlSessionTemplate.insert( this.getClass().getName() + ".save", account );

        sqlSessionTemplate.insert( this.getClass().getName() + ".saveAuthority", account );
    }

    @Override
    public boolean isEmailExist( Account account )
    {
        int countEmail = ( Integer )sqlSessionTemplate.selectOne( this.getClass().getName() + ".countEmail", account );

        if( countEmail == 0 ) return false;

        return true;
    }
}
