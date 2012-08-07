package com.pilgrim_lifestyle.service.eventer;

import com.pilgrim_lifestyle.model.eventer.Eventer;
import com.pilgrim_lifestyle.model.eventer.EventerRepository;
import com.pilgrim_lifestyle.model.eventer.contact.Contact;
import com.pilgrim_lifestyle.model.eventer.profile.Profile;
import com.pilgrim_lifestyle.model.eventer.security.Passwords;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service( "eventerService" )
public class EventerService
{
    @Autowired
    private EventerRepository eventerRepository;

    public void add( Contact contact, Profile profile, Passwords passwords )
    {
        Integer id = eventerRepository.nextId();

        Eventer eventer = new Eventer( id, profile, contact, passwords );

        eventerRepository.add( eventer );
    }
}
