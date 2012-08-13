package com.pilgrim_lifestyle.model.eventer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component( "registerEventerPolicy" )
public class RegisterEventerPolicy implements Validator
{
    @Autowired
    private EventerRepository eventerRepository;

    @Override
    public boolean supports( Class<?> clazz )
    {
        return Eventer.class.equals( clazz );
    }

    @Override
    public void validate( Object object, Errors errors )
    {
        Eventer eventer = ( Eventer ) object;

        this.duplicateEmail( eventer, errors );
    }

    private void duplicateEmail( Eventer eventer, Errors errors )
    {
        boolean isDuplicate = eventerRepository.isEmailExist( eventer );

        if(! isDuplicate ) return;

        String path =  "contact.mailAddress.mailAddress";
        String message = "指定のEmailアドレスは既に登録されています。";

        errors.rejectValue( path, null, message );
    }


}
