package dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.DatabaseDataSet;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.ext.postgresql.PostgresqlDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Test;

public class DataBaseSetup
{
    @Test
    public void databaseSetUp() throws SQLException
    {
        IDatabaseConnection connection = null;
        try
        {
            connection = getConnection();

            DatabaseConfig databaseConfig = connection.getConfig();
            databaseConfig.setProperty( DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new PostgresqlDataTypeFactory() );

            QueryDataSet queryDataSet = new QueryDataSet( connection );
            org.dbunit.database.DatabaseDataSet databaseDataSet = new DatabaseDataSet( connection, true );
            String[] a = databaseDataSet.getTableNames();


            for ( String tableName : Tables.tableMap.values() )
            {
                queryDataSet.addTable( tableName );
            }

            DatabaseOperation.DELETE_ALL.execute( connection, databaseDataSet );

        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
        finally
        {
            if( connection != null ) connection.close();
        }
    }

    private static IDatabaseConnection getConnection() throws Exception
    {
        ResourceBundle bundle = ResourceBundle.getBundle("META-INF/spring/jdbc");
        String className = bundle.getString( "jdbc.driverClassName" );
        String url = bundle.getString( "jdbc.url" );
        String username = bundle.getString( "jdbc.username" );
        String password = bundle.getString( "jdbc.password" );

        Class.forName( className );
        Connection connection = DriverManager.getConnection( url, username, password );

        return new DatabaseConnection( connection );
    }
}
