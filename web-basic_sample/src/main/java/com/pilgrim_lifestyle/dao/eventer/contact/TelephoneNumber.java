package com.pilgrim_lifestyle.dao.eventer.contact;

import java.io.Serializable;

import lombok.Data;

public @Data class TelephoneNumber implements Serializable
{
    private String number;

    private static final long serialVersionUID = -6667825250333571657L;
}
