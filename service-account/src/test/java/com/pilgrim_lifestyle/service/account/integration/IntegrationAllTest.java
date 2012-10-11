package com.pilgrim_lifestyle.service.account.integration;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.pilgrim_lifestyle.service.account.integration.RegisterAccountServiceImplTest;

@RunWith( value = Suite.class )
@SuiteClasses( value = {
        RegisterAccountServiceImplTest.class
})
public class IntegrationAllTest
{

}
