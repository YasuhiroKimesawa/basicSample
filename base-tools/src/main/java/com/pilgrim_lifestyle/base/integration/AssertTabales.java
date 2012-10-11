package com.pilgrim_lifestyle.base.integration;

import org.dbunit.Assertion;
import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.filter.DefaultColumnFilter;

public class AssertTabales
{
    private ActualTables acuActualTables;

    private ExpectedTables expectedTables;

    public AssertTabales( DatabaseDataSourceConnection connection, String expectedCSVPath ) throws Exception
    {
        expectedTables = new ExpectedTables( expectedCSVPath );

        acuActualTables = new ActualTables( connection, expectedTables.getTables() );
    }

    public void assertTables() throws Exception
    {
        for( String each : expectedTables.getTables() )
        {
            assertEquals( each );
        }
    }

    private void assertEquals( String tablename ) throws Exception
    {
        ITable actual = filetring( tablename );

        Assertion.assertEquals( expectedTables.getTable( tablename ), actual );
    }

    private ITable filetring( String tableName ) throws Exception
    {
        return DefaultColumnFilter.includedColumnsTable(
                acuActualTables.getTable( tableName ),
                expectedTables.getTable( tableName ).getTableMetaData().getColumns()
                );
    }
}
