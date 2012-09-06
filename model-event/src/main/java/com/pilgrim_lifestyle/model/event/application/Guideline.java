package com.pilgrim_lifestyle.model.event.application;

import java.text.ParseException;

import javax.validation.Valid;

import jp.pilgrim_ericclapton.model.primitive.date.TimeStamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Guideline
{
    @Valid
    private HeadCount headCount;

    @Valid
    private Period period;

    public Guideline( HeadCount headCount, Period period )
    {
        this.headCount = headCount;
        this.period = period;
    }

    public static Guideline draft()
    {
        HeadCount headCount = new HeadCount( "" );

        Period period = Period.draft();

        return new Guideline( headCount, period );
    }

    public TimeStamp endDateTimeStamp() throws ParseException
    {
        return period.getEndDate().getTimeStamp();
    }

}
