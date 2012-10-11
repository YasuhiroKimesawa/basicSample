package com.pilgrim_lifestyle.service.account;

import java.io.File;
import java.net.URL;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.csv.CsvDataSet;

public class ExpectedTables
{
    private IDataSet expectedTables;

    public ExpectedTables( String expectedCSVPath ) throws Exception
    {
        URL url = Thread.currentThread().getContextClassLoader().getResource( expectedCSVPath );

        IDataSet dataset = new CsvDataSet( new File( url.toURI() ) );

        expectedTables =  dataset;
    }

    public ITable getTable( String tableName ) throws Exception
    {
        return expectedTables.getTable( tableName );
    }

    public String[] getTables() throws Exception
    {
        return expectedTables.getTableNames();
    }
}
