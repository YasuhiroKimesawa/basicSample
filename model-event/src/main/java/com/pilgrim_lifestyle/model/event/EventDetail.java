package com.pilgrim_lifestyle.model.event;

import java.text.ParseException;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;

import com.pilgrim_lifestyle.model.event.application.Guideline;
import com.pilgrim_lifestyle.model.event.content.Content;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EventDetail
{
    @Valid
    private Guideline guideline;

    @Valid
    private Content content;

    @AssertTrue
    public boolean before() throws ParseException
    {
        return guideline.getPeriod().getEndDate().getTimeStamp().before( content.getDateOf().getTimeStamp() );
    }
}
