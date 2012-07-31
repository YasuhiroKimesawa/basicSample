package com.pilgrim_lifestyle.form.eventer;

import com.pilgrim_lifestyle.model.eventer.Eventer;
import com.pilgrim_lifestyle.model.eventer.contact.Contact;
import com.pilgrim_lifestyle.model.eventer.contact.MailAddress;
import com.pilgrim_lifestyle.model.eventer.contact.TelephoneNumber;
import com.pilgrim_lifestyle.model.eventer.profile.PersonName;
import com.pilgrim_lifestyle.model.eventer.profile.Profile;

import org.springframework.stereotype.Component;

@Component( "eventerFormDxo" )
public class EventerFormDxo
{
    public Eventer convert( EventerForm eventerForm )
    {
        PersonName personName = new PersonName( eventerForm.getLastName(), eventerForm.getLastName() );
        Profile profile = new Profile( personName );

        MailAddress mailAddress = new MailAddress( eventerForm.getMailAddress() );
        TelephoneNumber telephoneNumber = new TelephoneNumber( eventerForm.getTelophoneNumber() );
        Contact contact = new Contact( mailAddress, telephoneNumber );

        return new Eventer( profile, contact );
    }
}
