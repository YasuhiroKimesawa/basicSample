package com.pilgrim_lifestyle.model.event.application;

import javax.validation.Valid;

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
}
