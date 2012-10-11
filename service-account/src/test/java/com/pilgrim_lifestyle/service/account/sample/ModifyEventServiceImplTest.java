package jp.rhp.noactionaleartmail.service.event;

import jp.rhp.noactionaleartmail.service.AssertTabales;
import jp.rhp.noactionaleartmail.service.SetUpDataAccessTest;
import jp.rhp.noactionaleartmail.service.event.ModifyEventService;

import org.dbunit.database.DatabaseDataSourceConnection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration( value = "classpath:META-INF/spring/beans-all.xml" )
@RunWith( SpringJUnit4ClassRunner.class )
public class ModifyEventServiceImplTest
{
    @Autowired
    SetUpDataAccessTest setUpDataAccessTest;

    @Autowired
    private ModifyEventService modifyEventService;

    private DatabaseDataSourceConnection dbunitConnection;

    @Before
    public void before() throws Exception
    {
        String[] resetTables = { "hiring_process.noaction_alert_mail_request_events" };

        dbunitConnection = setUpDataAccessTest.setup( "./start/set", resetTables );
    }

    @Test
    public void registerTest() throws Exception
    {
        Integer noActionAlertMailRequestId = 1;

        modifyEventService.modifyStart( noActionAlertMailRequestId );

        AssertTabales assertTabales = new AssertTabales( dbunitConnection, "./start" );
        assertTabales.assertTables();
    }
}
