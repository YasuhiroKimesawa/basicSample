package com.pilgrim_lifestyle.model.eventer.personInfomation.contact;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

public @Data @NoArgsConstructor class MailAddress
{
    @Email( message = "メールアドレスはEメールの形式で入力して下さい。" )
    @NotEmpty( message = "メールアドレスを入力して下さい。" )
    @Length( max = 50, message = "メールアドレスは50文字以内で入力して下さい。" )
    private String mailAddress = "";

    public MailAddress( String mailAddress )
    {
        this.mailAddress = mailAddress;
    }

}
