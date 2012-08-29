package com.pilgrim_lifestyle.model.eventer;

import javax.validation.Valid;

import com.pilgrim_lifestyle.model.account.Account;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Eventer implements Account
{
    private Integer id;

    @Valid
    private EventerDetail eventerDetail;

    public Eventer( Integer id, EventerDetail eventerDetail )
    {
        this.id = id;

        this.eventerDetail = eventerDetail;
    }

    @Override
    public Account create( Integer id )
    {
        return new Eventer( id, this.eventerDetail );
    }

    @Override
    public String getAuthority()
    {
        return "ROLE_EVENTER";
    }

    public static Eventer draft()
    {
        EventerDetail eventerDetail = EventerDetail.draft();

        Integer id = 0;

        return new Eventer( id, eventerDetail );
    }
}
