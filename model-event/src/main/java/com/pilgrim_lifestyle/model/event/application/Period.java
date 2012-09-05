package com.pilgrim_lifestyle.model.event.application;

import java.text.ParseException;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Period
{
    @Valid
    private StartDate startDate;

    @Valid
    private EndDate endDate;

    @AssertTrue( message = "開始日が終了日より早くなければだめです。")
    public boolean before() throws ParseException
    {
        return startDate.getTimeStamp().before( endDate.getTimeStamp() );
    }

}
