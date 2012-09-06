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

    public Period( StartDate startDate, EndDate endDate )
    {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static Period draft()
    {
        StartDate startDate = StartDate.draft();
        EndDate endDate = EndDate.draft();

        return new Period( startDate, endDate );
    }

    @AssertTrue( message="募集開始日時は募集終了日時より前の日時にして下さい。")
    public boolean isAfterEndDate() throws ParseException
    {
        TimeStamp start = startDate.getTimeStamp();

        TimeStamp end = endDate.getTimeStamp();

        return start.before( end );
    }





}
