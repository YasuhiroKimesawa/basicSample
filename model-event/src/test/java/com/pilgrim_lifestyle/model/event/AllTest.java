package com.pilgrim_lifestyle.model.event;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.pilgrim_lifestyle.model.event.content.ContentTest;
import com.pilgrim_lifestyle.model.event.content.ExplanationTest;
import com.pilgrim_lifestyle.model.event.content.HeadCountTest;
import com.pilgrim_lifestyle.model.event.period.ApplicantDateRangeTest;
import com.pilgrim_lifestyle.model.event.period.DateOfTest;
import com.pilgrim_lifestyle.model.event.period.PeriodTest;

@RunWith( value = Suite.class )
@SuiteClasses( value = {
        EventTest.class
        , EventDetailTest.class
        , ContentTest.class
        , ExplanationTest.class
        , HeadCountTest.class
        , ApplicantDateRangeTest.class
        , DateOfTest.class
        , PeriodTest.class
})
public class AllTest
{

}
