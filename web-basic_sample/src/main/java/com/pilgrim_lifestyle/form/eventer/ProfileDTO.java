package com.pilgrim_lifestyle.form.eventer;

import java.io.Serializable;

import lombok.Data;

public @Data class ProfileDTO implements Serializable
{

    private String lastName;

    private String firstName;

    private static final long serialVersionUID = -7824510476829185831L;

}
