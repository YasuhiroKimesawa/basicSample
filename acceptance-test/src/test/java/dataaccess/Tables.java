package dataaccess;

import java.util.EnumMap;
import java.util.Map;

public enum Tables
{
    EVENTER( "eventer" );

    private String name;

    private Tables( String schema )
    {
        this.name = schema;
    }

    public String getName()
    {
        return name;
    }

    public static Map<Tables, String> tableMap = new EnumMap<Tables, String>( Tables.class );
    static
    {
        for( Tables each : Tables.values() )
        {
            tableMap.put( each, each.name );
        }
    }
}
