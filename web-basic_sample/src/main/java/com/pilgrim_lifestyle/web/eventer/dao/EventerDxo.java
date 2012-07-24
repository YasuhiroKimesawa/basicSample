package com.pilgrim_lifestyle.web.eventer.dao;

import com.pilgrim_lifestyle.model.eventer.Eventer;

import com.pilgrim_lifestyle.model.eventer.contact.Contact;
import com.pilgrim_lifestyle.model.eventer.contact.MailAddress;
import com.pilgrim_lifestyle.model.eventer.contact.TelephoneNumber;

import com.pilgrim_lifestyle.model.eventer.profile.PersonName;
import com.pilgrim_lifestyle.model.eventer.profile.Profile;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;

@Component( "eventerDxo" )
public class EventerDxo
{
    private EventerDao eventerDao;

    public Eventer convert( EventerDao eventerDao )
    {
        this.eventerDao = eventerDao;

        Contact contact = createContact();

        Profile profile = createProfile();

        return new Eventer( profile, contact );
    }

    private Contact createContact()
    {
        TelephoneNumber telephoneNumber = new TelephoneNumber( (String) this.getProperty( "eventerDao.contact.telephoneNumber.number" ) );
        MailAddress mailAddress = new MailAddress( (String) this.getProperty( "eventerDao.contact.mailAddress.mailAddress" ) );
        Contact contact = new Contact( mailAddress, telephoneNumber );
        return contact;
    }

    private Profile createProfile()
    {
        PersonName personName = new PersonName( (String) this.getProperty( "eventerDao.profile.personName.lastName" ),
                (String) this.getProperty( "eventerDao.profile.personName.firstName" ) );
        Profile profile = new Profile( personName );
        return profile;
    }

    public Object getProperty( String string )
    {
        BeanWrapper beanWrapper = new BeanWrapperImpl( eventerDao );

        return beanWrapper.getPropertyValue( string );
    }
}
