package com.pilgrim_lifestyle.model.eventer.security;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Password
{
    @Pattern( regexp = "^[a-zA-Z!-~]*|", message = "パスワードに使用できる文字は半角英数字記号です。")
    @Length( min = 4, max = 8, message = "パスワードは４文字以上8文字以下で入力してください。" )
    @NotEmpty( message = "パスワードを入力して下さい。" )
    private String password;

    public Password( String password )
    {
        this.password = password;
    }

}
