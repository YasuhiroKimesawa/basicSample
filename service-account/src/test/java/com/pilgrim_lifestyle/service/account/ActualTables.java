package com.pilgrim_lifestyle.service.account;

import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;

public class ActualTables
{
    private DatabaseDataSourceConnection connection;

    private IDataSet actualTables;

    public ActualTables( DatabaseDataSourceConnection connection, String[] tables ) throws Exception
    {
        this.connection = connection;

        setActualTable( tables );
    }

    private void setActualTable( String[] tables ) throws Exception
    {
        QueryDataSet partialDataSet = new QueryDataSet( connection );

        for( String each : tables )
        {
            partialDataSet.addTable( each );
        }

        actualTables = partialDataSet;
    }

    public ITable getTable( String table ) throws Exception
    {
        return actualTables.getTable( table );
    }
}
