package com.pilgrim_lifestyle.service.account.integration;

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
import com.pilgrim_lifestyle.model.eventer.CreateEventer;
import com.pilgrim_lifestyle.model.eventer.Eventer;
import com.pilgrim_lifestyle.model.eventer.EventerData;
import com.pilgrim_lifestyle.service.account.RegisterAccountService;

@ContextConfiguration( locations = {
        "classpath:META-INF/spring/beans-service-base.xml"
        , "classpath:META-INF/spring/beans-model-base.xml"
        , "classpath:META-INF/spring/beans-dataaccess-base.xml"
        , "classpath:META-INF/spring/beans-dataaccess-datasource-basic.xml"
        , "classpath:META-INF/spring/beans-integration-dataaccess-base.xml"
        } )
@RunWith( SpringJUnit4ClassRunner.class )
public class RegisterAccountServiceImplTest
{
    @Autowired
    SetUpDataAccessTest setUpDataAccessTest;

    @Autowired
    private RegisterAccountService registerAccountService;

    private DatabaseDataSourceConnection dbunitConnection;

    @Before
    public void before() throws Exception
    {
        String[] resetTables = { "event.event", "account.authority", "account.account"  };

        dbunitConnection = setUpDataAccessTest.setup( resetTables );
    }

    @Test
    public void registerTest() throws Exception
    {
        Map<EventerData.Data, String> eventerData = new EventerData().getData();
        Eventer eventer = CreateEventer.instansOf( eventerData ).createEventer();

        registerAccountService.register( eventer );

        AssertTabales assertTabales = new AssertTabales( dbunitConnection, "./result" );
        assertTabales.assertTables();
    }
}
