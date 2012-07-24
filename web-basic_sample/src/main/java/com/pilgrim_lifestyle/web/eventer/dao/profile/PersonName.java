package com.pilgrim_lifestyle.web.eventer.dao.profile;

import java.io.Serializable;

import lombok.Data;

public @Data class PersonName implements Serializable
{

    private String lastName;

    private String firstName;

    private static final long serialVersionUID = -7335627686287177364L;

}
