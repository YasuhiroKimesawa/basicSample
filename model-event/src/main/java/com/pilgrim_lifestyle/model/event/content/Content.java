package com.pilgrim_lifestyle.model.event.content;

import javax.validation.Valid;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Content
{

    @Valid
    private DateOf dateOf;

    @Valid
    private Explanation explanation;

    public Content( DateOf dateOf, Explanation explanation )
    {
        this.dateOf = dateOf;
        this.explanation = explanation;
    }

    public static Content draft()
    {
        DateOf dateOf = DateOf.draft();

        Explanation explanation = new Explanation( "" );

        return new Content( dateOf, explanation );
    }

}
