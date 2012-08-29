package com.pilgrim_lifestyle.model.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.pilgrim_lifestyle.model.account.Account;
import com.pilgrim_lifestyle.model.account.AccountRepository;

@Component( "accountPolicy" )
public class AccountPolicy implements Validator
{
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public boolean supports( Class<?> clazz )
    {
        return Account.class.equals( clazz );
    }

    @Override
    public void validate( Object object, Errors errors )
    {
        Account account = ( Account ) object;

        this.duplicateEmail( account, errors );
    }

    private void duplicateEmail( Account account, Errors errors )
    {
        boolean isDuplicate = accountRepository.isEmailExist( account );

        if(! isDuplicate ) return;

        String path =  "eventerDetail.personalInfomation.contact.mailAddress.mailAddress";
        String message = "指定のEmailアドレスは既に登録されています。";

        errors.rejectValue( path, null, message );
    }


}
