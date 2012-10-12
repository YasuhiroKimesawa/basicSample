package com.pilgrim_lifestyle.base.integration;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.dataset.DefaultDataSet;
import org.dbunit.dataset.DefaultTable;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.csv.CsvDataSet;
import org.dbunit.dataset.datatype.IDataTypeFactory;
import org.dbunit.ext.postgresql.PostgresqlDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component( "setUpDataAccessTest" )
public class SetUpDataAccessTest
{
    @Autowired
    private DataSource dataSource;

    private DatabaseDataSourceConnection dbunitConnection;

    public DatabaseDataSourceConnection setup( String initialDataPath, String[] resetTabels ) throws SQLException, Exception
    {
        setProperties();

        resetDb( resetTabels );

        initialDateSet( initialDataPath );

        return dbunitConnection;
    }

    public DatabaseDataSourceConnection setup( String[] resetTabels ) throws SQLException, Exception
    {
        setProperties();

        resetDb( resetTabels );

        return dbunitConnection;
    }

    private IDataTypeFactory getDataTypeFactory()
    {
        return new PostgresqlDataTypeFactory();
    }

    private DatabaseDataSourceConnection setProperties() throws Exception
    {
        dbunitConnection = new DatabaseDataSourceConnection( dataSource );
        DatabaseConfig databaseConfig = dbunitConnection.getConfig();
        databaseConfig.setProperty( DatabaseConfig.PROPERTY_DATATYPE_FACTORY, getDataTypeFactory() );
        databaseConfig.setProperty( DatabaseConfig.FEATURE_QUALIFIED_TABLE_NAMES, true );

        return dbunitConnection;
    }

    private void resetDb( String[] resetTabel ) throws Exception
    {
        if( resetTabel.length == 0 ) return;

        for( String each : resetTabel )
        {
            ITable table = new DefaultTable( each );
            IDataSet dataSet = new DefaultDataSet( table );
            DatabaseOperation.DELETE_ALL.execute( dbunitConnection, dataSet );
        }
    }

    private void initialDateSet( String pathName ) throws Exception, URISyntaxException
    {
        if( pathName.isEmpty() ) return;

        URL url = Thread.currentThread().getContextClassLoader().getResource( pathName );

        IDataSet dataSet = new  CsvDataSet( new File( url.toURI() ) );
        DatabaseOperation.CLEAN_INSERT.execute( dbunitConnection,dataSet );
    }
}
