package com.pilgrim_lifestyle.table.eventer;

import com.pilgrim_lifestyle.model.eventer.Eventer;
import com.pilgrim_lifestyle.model.eventer.contact.Contact;
import com.pilgrim_lifestyle.model.eventer.contact.MailAddress;
import com.pilgrim_lifestyle.model.eventer.contact.TelephoneNumber;
import com.pilgrim_lifestyle.model.eventer.profile.PersonName;
import com.pilgrim_lifestyle.model.eventer.profile.Profile;
import com.pilgrim_lifestyle.model.eventer.security.Password;
import com.pilgrim_lifestyle.model.eventer.security.Passwords;

import org.springframework.beans.ConfigurablePropertyAccessor;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.stereotype.Component;

@Component( "eventerTableDxo" )
public class EventerTableDxo
{
    public EventerTable toDto( Eventer eventer )
    {
        Integer id = (Integer) this.getPropertyValue( eventer, "id" );
        Profile profile = (Profile) this.getPropertyValue( eventer, "profile" );
        Contact contact = (Contact) this.getPropertyValue( eventer, "contact" );
        Passwords passwords = (Passwords) this.getPropertyValue( eventer, "passwords" );

        PersonName personName = (PersonName) this.getPropertyValue( profile, "personName" );
        String lastName = (String) this.getPropertyValue( personName, "lastName" );
        String firstName = (String) this.getPropertyValue( personName, "firstName" );

        MailAddress mailAddress = (MailAddress) this.getPropertyValue( contact, "mailAddress" );
        String address = (String) this.getPropertyValue( mailAddress, "mailAddress" );

        TelephoneNumber telephoneNumber = (TelephoneNumber) this.getPropertyValue( contact, "telephoneNumber" );
        String number = (String) this.getPropertyValue( telephoneNumber, "number" );

        Password password = (Password) this.getPropertyValue( passwords, "password" );
        String pass = (String) this.getPropertyValue( password, "password" );

        EventerPasswordTable eventerPasswordTable = new EventerPasswordTable( pass );

        return new EventerTable( id, lastName, firstName, number, address, eventerPasswordTable );

    }

    private <T> Object getPropertyValue( T object, String fieldName )
    {
        ConfigurablePropertyAccessor fieldAccessor = PropertyAccessorFactory.forDirectFieldAccess( object );

        String FieldNameFromObject = this.getFieldName( object, fieldName );

        return fieldAccessor.getPropertyValue( FieldNameFromObject );
    }

    private <T> String getFieldName( T object, String filedName )
    {
        try
        {
            return object.getClass().getDeclaredField( filedName ).getName();
        }
        catch ( SecurityException securityException )
        {
            throw new RuntimeException( securityException.getMessage() );
        }
        catch ( NoSuchFieldException noSuchFieldException )
        {
            throw new RuntimeException( noSuchFieldException.getMessage() );
        }
    }

}
