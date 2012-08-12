package com.pilgrim_lifestyle.form.eventer;

import lombok.Data;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public @Data class PasswordsDTO implements Serializable
{
    @Pattern( regexp = "^[a-zA-Z!-~]*|", message = "パスワードに使用できる文字は半角英数字記号です。")
    @Length( min = 4, max = 8, message = "パスワードは４文字以上8文字以下で入力してください。" )
    private String password;

    private String confirm;

    public PasswordsDTO()
    {
        this.password = "";
        this.confirm = "";
    }

    public boolean isConform()
    {
        return true;
    }

    private static final long serialVersionUID = 2553067987698913675L;

}
