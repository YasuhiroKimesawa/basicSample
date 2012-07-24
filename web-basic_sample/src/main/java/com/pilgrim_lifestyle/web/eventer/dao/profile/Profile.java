package com.pilgrim_lifestyle.web.eventer.dao.profile;

import java.io.Serializable;

import lombok.Data;

public @Data class Profile implements Serializable
{
    private PersonName personName;

    private static final long serialVersionUID = -325708925680799663L;
}
