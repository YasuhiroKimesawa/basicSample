package com.pilgrim_lifestyle.form.eventer;

import com.pilgrim_lifestyle.web.tool.Trim;

import lombok.Data;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public @Data class ProfileDTO implements Serializable
{
    @NotEmpty( message="姓を入力して下さい。" )
    @Length( max=12, message="姓は12文字以内で入力して下さい" )
    private String lastName;

    @NotEmpty( message="名を入力して下さい。" )
    @Length( max=12, message="名は12文字以内で入力して下さい" )
    private String firstName;

    public String getLastName()
    {
        return Trim.trim( lastName );
    }

    public String getFirstName()
    {
        return Trim.trim( firstName );
    }

    public ProfileDTO()
    {
        this.lastName = "";
        this.firstName = "";
    }

    private static final long serialVersionUID = -7824510476829185831L;

}
