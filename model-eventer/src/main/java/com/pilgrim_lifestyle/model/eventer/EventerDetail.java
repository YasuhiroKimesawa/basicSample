package com.pilgrim_lifestyle.model.eventer;

import com.pilgrim_lifestyle.model.eventer.personInfomation.PersonalInfomation;
import com.pilgrim_lifestyle.model.eventer.security.Passwords;

import javax.validation.Valid;

import lombok.Data;
import lombok.NoArgsConstructor;

public @Data @NoArgsConstructor class EventerDetail
{
    @Valid
    private PersonalInfomation personalInfomation;

    @Valid
    private Passwords passwords;

    public EventerDetail( PersonalInfomation personalInfomation, Passwords passwords )
    {
        this.personalInfomation = personalInfomation;

        this.passwords = passwords;
    }

    public static EventerDetail draft()
    {
        PersonalInfomation personalInfomation = PersonalInfomation.draft();

        Passwords passwords = Passwords.draft();

        return new EventerDetail( personalInfomation, passwords );
    }

}
