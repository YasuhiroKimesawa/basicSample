package com.pilgrim_lifestyle.dao.eventer.contact;

import java.io.Serializable;

import lombok.Data;

public @Data class MailAddress implements Serializable
{
    private String mailAddress;

    private static final long serialVersionUID = -8634800736082294854L;
}
