package com.pilgrim_lifestyle.model.event.application;

import java.text.ParseException;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;

import jp.pilgrim_ericclapton.model.primitive.date.TimeStamp;

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

    @AssertTrue( message="募集開始日時は募集終了日時より前の日時にして下さい。")
    public boolean isAfterEndDate() throws ParseException
    {
        TimeStamp start = startDate.getTimeStamp();

        TimeStamp end = endDate.getTimeStamp();

        return start.before( end );
    }

}
