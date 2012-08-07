package com.pilgrim_lifestyle.table.eventer;

public class EventerTable
{
    private Integer id;
    private String lastName;
    private String firstName;
    private String telephoneNumber;
    private String mailAddress;
    private EventerPasswordTable eventerPasswordTable;

    public EventerTable( Integer id, String lastName, String firstName, String telephoneNumber, String mailAddress, EventerPasswordTable eventerPasswordTable )
    {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.telephoneNumber = telephoneNumber;
        this.mailAddress = mailAddress;
        this.eventerPasswordTable = eventerPasswordTable;
    }

    public Integer getId()
    {
        return id;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getTelephoneNumber()
    {
        return telephoneNumber;
    }

    public String getMailAddress()
    {
        return mailAddress;
    }

    public EventerPasswordTable getEventerPasswordTable()
    {
        return eventerPasswordTable;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }

    public void setLastName( String lastName )
    {
        this.lastName = lastName;
    }

    public void setFirstName( String firstName )
    {
        this.firstName = firstName;
    }

    public void setTelephoneNumber( String telephoneNumber )
    {
        this.telephoneNumber = telephoneNumber;
    }

    public void setMailAddress( String mailAddress )
    {
        this.mailAddress = mailAddress;
    }

    public void setEventerPasswordTable( EventerPasswordTable eventerPasswordTable )
    {
        this.eventerPasswordTable = eventerPasswordTable;
    }

    @Override
    public String toString()
    {
        return "EventerTable [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", telephoneNumber=" + telephoneNumber + ", mailAddress="
                + mailAddress + "]";
    }

    public EventerTable()
    {
        ;
    }

}
