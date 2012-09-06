package com.pilgrim_lifestyle.model.event.application;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HeadCount
{
    @NotEmpty( message = "人数を入力して下さい。" )
    private String headCount;

    public HeadCount( String headCount )
    {
        this.headCount = headCount;
    }
}
