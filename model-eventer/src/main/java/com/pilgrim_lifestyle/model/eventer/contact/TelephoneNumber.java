package com.pilgrim_lifestyle.model.eventer.contact;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.ToString;

@ToString
public class TelephoneNumber
{
    @Pattern( regexp="^[0-9]{4}[-][0-9]{4}[-][0-9]{4}|", message="電話番号は「4桁内-4桁内-4桁」形式で入力して下さい")
    @NotEmpty( message="電話番号を入力して下さい。" )
    private String number;

    public TelephoneNumber( String number )
    {
        this.number = number;
    }
}
