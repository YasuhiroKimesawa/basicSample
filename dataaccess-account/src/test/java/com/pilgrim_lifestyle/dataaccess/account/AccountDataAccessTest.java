package com.pilgrim_lifestyle.dataaccess.account;

import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.dbunit.database.DatabaseDataSourceConnection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pilgrim_lifestyle.base.integration.AssertTabales;
import com.pilgrim_lifestyle.base.integration.SetUpDataAccessTest;
import com.pilgrim_lifestyle.model.account.Account;
import com.pilgrim_lifestyle.model.account.AccountRepository;
import com.pilgrim_lifestyle.model.eventer.CreateEventer;
import com.pilgrim_lifestyle.model.eventer.EventerData;

@ContextConfiguration( locations = {
        "classpath:META-INF/spring/beans-dataaccess-base.xml"
        , "classpath:META-INF/spring/beans-dataaccess-datasource-basic.xml"
        , "classpath:META-INF/spring/beans-integration-dataaccess-base.xml"
        } )
@RunWith( SpringJUnit4ClassRunner.class )
public class AccountDataAccessTest
{
    @Autowired
    SetUpDataAccessTest setUpDataAccessTest;

    @Autowired
    private AccountRepository accountRepository;

    private DatabaseDataSourceConnection dbunitConnection;

    @Before
    public void before() throws Exception
    {
        String[] resetTables = {  "event.event", "account.authority", "account.account"  };

        dbunitConnection = setUpDataAccessTest.setup( "./setup", resetTables );
    }

    @Test
    public void addTest() throws Exception
    {
        Map<EventerData.Data, String> eventerData = new EventerData().getData();
        Account eventer = CreateEventer.instansOf( eventerData ).createEventer();

        accountRepository.add( eventer );

        AssertTabales assertTabales = new AssertTabales( dbunitConnection, "./result" );
        assertTabales.assertTables();
    }

    @Test
    public void isEmailExistTest()
    {
        Map<EventerData.Data, String> eventerData = new EventerData().getData();
        eventerData.put( EventerData.Data.メールアドレス, "t99.tanaka@urawareds.com" );
        Account eventer = CreateEventer.instansOf( eventerData ).createEventer();

        boolean expected = accountRepository.isEmailExist( eventer );

        assertTrue( expected );
    }

}
