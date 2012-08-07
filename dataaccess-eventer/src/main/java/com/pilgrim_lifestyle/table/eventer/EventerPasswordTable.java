package com.pilgrim_lifestyle.table.eventer;

public class EventerPasswordTable
{
    private String password;

    public EventerPasswordTable( String password )
    {
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }

    @Override
    public String toString()
    {
        return "EventerPasswordTable [password=" + password + "]";
    }
}
