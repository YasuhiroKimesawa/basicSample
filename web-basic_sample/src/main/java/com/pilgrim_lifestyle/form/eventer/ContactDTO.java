package com.pilgrim_lifestyle.form.eventer;

import com.pilgrim_lifestyle.web.tool.Trim;

import lombok.Data;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


public @Data class ContactDTO implements Serializable
{
    @Pattern( regexp="^[0-9]{0,4}[-][0-9]{0,4}[-][0-9]{4}|", message="電話番号は「4桁内-4桁内-4桁」形式で入力して下さい")
    @NotEmpty( message="電話番号を入力して下さい。" )
    private String telephoneNumber;

    @Email( message = "メールアドレスはEメールの形式で入力して下さい。" )
    @NotEmpty( message = "メールアドレスを入力して下さい。" )
    @Length( max = 50, message = "メールアドレスは50文字以内で入力して下さい。" )
    private String mailAddress;

    public String getTelephoneNumber()
    {
        return Trim.trim( telephoneNumber );
    }

    public String getMailAddress()
    {
        return Trim.trim( mailAddress );
    }

    public ContactDTO()
    {
        this.telephoneNumber = "";
        this.mailAddress = "";
    }

    private static final long serialVersionUID = 1647513382395277415L;

}
