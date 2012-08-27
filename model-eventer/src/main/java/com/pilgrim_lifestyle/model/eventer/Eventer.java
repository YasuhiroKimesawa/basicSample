package com.pilgrim_lifestyle.model.eventer;

import javax.validation.Valid;

import lombok.Data;
import lombok.NoArgsConstructor;


public @Data @NoArgsConstructor class Eventer
{
    private Integer id;

    @Valid
    private EventerDetail eventerDetail;

    public Eventer( Integer id, EventerDetail eventerDetail )
    {
        this.id = id;

        this.eventerDetail = eventerDetail;
    }

    public static Eventer draft()
    {
        EventerDetail eventerDetail = EventerDetail.draft();

        Integer id = 0;

        return new Eventer( id, eventerDetail );
    }
}
