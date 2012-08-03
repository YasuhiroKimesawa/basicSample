package com.pilgrim_lifestyle.model.eventer.contact;

import javax.validation.constraints.Max;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.ToString;

@ToString
public class MailAddress
{
    @Email( message = "メールアドレスはEメールの形式で入力して下さい。" )
    @NotEmpty( message = "メールアドレスを入力して下さい。" )
    @Max( value = 50, message = "メールアドレスは50文字以内で入力して下さい。" )
    private String mailAddress;

    public MailAddress( String mailAddress )
    {
        this.mailAddress = mailAddress;
    }
}
