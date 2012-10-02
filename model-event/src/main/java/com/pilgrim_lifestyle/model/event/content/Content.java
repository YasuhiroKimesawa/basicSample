package com.pilgrim_lifestyle.model.event.content;

import javax.validation.Valid;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Content
{

    @Valid
    private HeadCount headCount;

    @Valid
    private Explanation explanation;

    public Content( HeadCount headCount, Explanation explanation )
    {
        this.headCount = headCount;
        this.explanation = explanation;
    }

    public static Content draft()
    {
        HeadCount headCount = new HeadCount( "" );

        Explanation explanation = new Explanation( "" );

        return new Content( headCount, explanation );
    }

}
