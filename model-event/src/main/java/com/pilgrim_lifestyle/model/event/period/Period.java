package com.pilgrim_lifestyle.model.event.period;

import jp.pilgrim_ericclapton.model.primitive.date.range.TimeStampRange;

import java.text.ParseException;

import javax.validation.constraints.AssertTrue;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Period
{
    private DateOf dateOf;

    private ApplicantDateRange applicantDateRange;

    public static Period draft()
    {
        DateOf dateOf = DateOf.draft();

        ApplicantDateRange applicantDateRange = ApplicantDateRange.draft();

        return new Period( dateOf, applicantDateRange );
    }

    @AssertTrue( message="イベント日時は応募終了日時より後を指定して下さい。" )
    public boolean isCollect() throws ParseException
    {
        TimeStampRange timestampRange = TimeStampRange.instanceOf( applicantDateRange.getEnd(), dateOf.getTimeStampFormat() );

        return timestampRange.isCollect();
    }

    public Period( DateOf dateOf, ApplicantDateRange applicantDateRange )
    {
        this.dateOf = dateOf;
        this.applicantDateRange = applicantDateRange;
    }

}
