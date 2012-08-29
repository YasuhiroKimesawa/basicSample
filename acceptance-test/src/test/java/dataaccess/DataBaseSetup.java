package dataaccess;

import java.io.InputStream;

import javax.sql.DataSource;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.datatype.IDataTypeFactory;
import org.dbunit.dataset.excel.XlsDataSet;
import org.dbunit.ext.postgresql.PostgresqlDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration( value = "classpath:META-INF/spring/beans-dataaccess.xml" )
@RunWith( SpringJUnit4ClassRunner.class )
public class DataBaseSetup
{
    @Autowired
    private DataSource dataSource;

    private DatabaseDataSourceConnection dbunitConnection;

    @Before
    public void before() throws Exception
    {
        dbunitConnection = new DatabaseDataSourceConnection( dataSource );
        DatabaseConfig databaseConfig = dbunitConnection.getConfig();
        databaseConfig.setProperty( DatabaseConfig.PROPERTY_DATATYPE_FACTORY, getDataTypeFactory() );
        databaseConfig.setProperty( DatabaseConfig.FEATURE_QUALIFIED_TABLE_NAMES, true );

    }

    private IDataTypeFactory getDataTypeFactory()
    {
        return new PostgresqlDataTypeFactory();
    }

    @Test
    public void databaseSetUp() throws Exception
    {
        // clean
        QueryDataSet initDataSet = new QueryDataSet( dbunitConnection );
        initDataSet.addTable( "eventer.eventer" );
        DatabaseOperation.DELETE_ALL.execute( dbunitConnection, initDataSet );

        // insert
        InputStream str =  ClassLoader.class.getResourceAsStream( "/basicsample.xls" );

        IDataSet dataset = new XlsDataSet( str );
        DatabaseOperation.CLEAN_INSERT.execute( dbunitConnection, dataset );
    }

}
