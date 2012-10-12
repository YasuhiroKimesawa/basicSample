package com.pilgrim_lifestyle.dataaccess.event;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import mockit.Expectations;
import mockit.Mocked;

import org.dbunit.database.DatabaseDataSourceConnection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pilgrim_lifestyle.base.integration.AssertTabales;
import com.pilgrim_lifestyle.base.integration.SetUpDataAccessTest;
import com.pilgrim_lifestyle.model.event.CreateEvent;
import com.pilgrim_lifestyle.model.event.Event;
import com.pilgrim_lifestyle.model.event.EventData;
import com.pilgrim_lifestyle.model.event.EventRepository;
import com.pilgrim_lifestyle.security.model.AccountUser;
import com.pilgrim_lifestyle.security.model.AccountUserHelper;

@ContextConfiguration( locations = {
        "classpath:META-INF/spring/beans-dataaccess-base.xml"
        , "classpath:META-INF/spring/beans-dataaccess-datasource-basic.xml"
        , "classpath:META-INF/spring/beans-integration-dataaccess-base.xml"
        } )
@RunWith( SpringJUnit4ClassRunner.class )
public class EventDataAccessTest
{
    @Autowired
    SetUpDataAccessTest setUpDataAccessTest;

    @Autowired
    private EventRepository eventRepository;

    private DatabaseDataSourceConnection dbunitConnection;

    @Mocked
    final AccountUserHelper accountUserHelper = null;

    @Before
    public void before() throws Exception
    {
        String[] resetTables = {  "event.event", "account.authority", "account.account"  };

        dbunitConnection = setUpDataAccessTest.setup( "./setup", resetTables );
    }

    @Test
    public void registerTest() throws Exception
    {
        new Expectations()
        {{
            Collection<GrantedAuthority> au = new ArrayList<GrantedAuthority>();
            au.add( new SimpleGrantedAuthority( "ROLE_EVENTER" ) );
            AccountUserHelper.getLoginUser();result = new AccountUser(1, "urawa@mail.com", "田中", "ROLE_EVENTER", au);
        }};

        Map<EventData.Data, String> eventData = new EventData().getData();
        Event event = CreateEvent.createEvent( eventData );

        eventRepository.register( event );

        AssertTabales assertTabales = new AssertTabales( dbunitConnection, "./result" );
        assertTabales.assertTables();
    }

}
