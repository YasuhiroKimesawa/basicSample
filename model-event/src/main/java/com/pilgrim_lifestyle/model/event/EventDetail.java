package com.pilgrim_lifestyle.model.event;

import java.text.ParseException;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;

import jp.pilgrim_ericclapton.model.primitive.date.TimeStamp;

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

    public EventDetail( Guideline guideline, Content content )
    {
        this.guideline = guideline;
        this.content = content;
    }

    public static EventDetail draft()
    {
        Guideline guideline = Guideline.draft();
        Content content = Content.draft();

        return new EventDetail( guideline, content );
    }

    @AssertTrue( message="イベント日時は募集終了日時より後の日時にして下さい。")
    public boolean AfterDateOf() throws ParseException
    {
        TimeStamp dateOf = content.getDateOf().getTimeStamp();

        TimeStamp endDate = guideline.endDateTimeStamp();

        return endDate.before( dateOf );
    }
}
