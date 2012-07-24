package com.pilgrim_lifestyle.dataaccess.eventer.dao.contact;

import lombok.Data;

public @Data class Contact
{
    private MailAddress mailAddress;

    private TelephoneNumber telephoneNumber;
}
