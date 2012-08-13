package com.pilgrim_lifestyle.form.eventer;

import com.pilgrim_lifestyle.model.eventer.Eventer;
import com.pilgrim_lifestyle.model.eventer.contact.Contact;
import com.pilgrim_lifestyle.model.eventer.contact.MailAddress;
import com.pilgrim_lifestyle.model.eventer.contact.TelephoneNumber;
import com.pilgrim_lifestyle.model.eventer.profile.PersonName;
import com.pilgrim_lifestyle.model.eventer.profile.Profile;
import com.pilgrim_lifestyle.model.eventer.security.Password;
import com.pilgrim_lifestyle.model.eventer.security.Passwords;

import org.springframework.stereotype.Component;

@Component( "eventerDxo" )
public class EventerDxo
{
    private static Integer DEFAULT_EVENTER_ID = 0;

    public Eventer fromDTO( EventerForm eventerForm )
    {
        Profile profile = this.fromProfileDTO( eventerForm.getProfile() );

        Contact contact = this.fromContactDTO( eventerForm.getContact() );

        Passwords passwords = this.fromPasswordsDTO( eventerForm.getPasswords() );

        return new Eventer( DEFAULT_EVENTER_ID, profile, contact, passwords );
    }

    public Profile fromProfileDTO( ProfileDTO profileDTO )
    {
        PersonName personName = new PersonName( profileDTO.getPersonName().getLastName(),
                profileDTO.getPersonName().getFirstName() );

        return new Profile( personName );
    }

    public Contact fromContactDTO( ContactDTO contactDTO )
    {
        MailAddress mailAddress = new MailAddress( contactDTO.getMailAddress().getMailAddress() );
        TelephoneNumber telephoneNumber = new TelephoneNumber( contactDTO.getTelephoneNumber().getNumber() );

        return new Contact( mailAddress, telephoneNumber );
    }

    public Passwords fromPasswordsDTO( PasswordsDTO passwordsDTO )
    {
        Password password = new Password( passwordsDTO.getPassword().getPassword() );
        Password confirm = new Password( passwordsDTO.getConfirm().getPassword() );

        return new Passwords( password, confirm );
    }
}
