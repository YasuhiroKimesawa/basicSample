package com.pilgrim_lifestyle.dataaccess.eventer.dao;

import com.pilgrim_lifestyle.model.eventer.Eventer;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.ConfigurablePropertyAccessor;
import org.springframework.beans.PropertyAccessorFactory;

public class EventerDxo
{
    private BeanWrapper beanWrapper;

    private ConfigurablePropertyAccessor fieldAccessor;

    public EventerDao convert( Eventer eventer )
    {
        EventerDao eventerDao = new EventerDao();

        beanWrapper = new BeanWrapperImpl( eventerDao );

        fieldAccessor = PropertyAccessorFactory.forDirectFieldAccess( eventer );

        for( Fields fields : Fields.values() )
        {
            this.setValue( fields.getPath() );
        }

        return eventerDao;
    }

    private void setValue( String str )
    {
        beanWrapper.setPropertyValue( str, this.getProperty( str ) );
    }

    private Object getProperty( String str )
    {
        return this.fieldAccessor.getPropertyValue( str );
    }

    private static enum Fields
    {
        MAILADDRESS( "contact.mailAddress.mailAddress" ),
        TELEPHONE_NUMBER( "contact.telephoneNumber.number" ),
        PERSON_LAST_NAME( "profile.personName.lastName" ),
        PERSON_FIRST_NAME( "profile.personName.firstNameName" );

        private String path;

        private Fields( String path )
        {
            this.path = path;
        }

        public String getPath()
        {
            return path;
        }
    }

}
