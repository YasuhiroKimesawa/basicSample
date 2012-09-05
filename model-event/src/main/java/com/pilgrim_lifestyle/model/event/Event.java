package com.pilgrim_lifestyle.model.event;

import javax.validation.Valid;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Event
{
    private Integer id;

    @Valid
    private EventDetail eventDetail;

}
