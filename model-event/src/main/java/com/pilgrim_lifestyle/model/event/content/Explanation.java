package com.pilgrim_lifestyle.model.event.content;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Explanation
{
    @NotEmpty( message = "イベント説明を入力して下さい。" )
    private String explanation;

    public Explanation( String explanation )
    {
        this.explanation = explanation;
    }

}
