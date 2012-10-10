package com.pilgrim_lifestyle.model.event;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Event
{
    private Integer id;

    @NotEmpty( message = "イベント名を入力して下さい。" )
    @Size( max=50, message = "イベント名は50文字以内で入力して下さい。" )
    private String name;

    @Valid
    private EventDetail eventDetail;

    public Event( Integer id, String name, EventDetail eventDetail )
    {
        this.id = id;
        this.name = name;
        this.eventDetail = eventDetail;
    }

    public static Event draft( Integer newId )
    {
        Integer id = newId;
        String name = "";
        EventDetail eventDetail = EventDetail.draft();

        return new Event( id, name , eventDetail);
    }

}
