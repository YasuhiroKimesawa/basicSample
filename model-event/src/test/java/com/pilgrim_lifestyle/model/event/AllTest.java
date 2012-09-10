package com.pilgrim_lifestyle.model.event;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.pilgrim_lifestyle.model.event.application.EndDateTest;
import com.pilgrim_lifestyle.model.event.application.GuidelineTest;
import com.pilgrim_lifestyle.model.event.application.HeadCountTest;
import com.pilgrim_lifestyle.model.event.application.PeriodTest;
import com.pilgrim_lifestyle.model.event.application.StartDateTest;
import com.pilgrim_lifestyle.model.event.content.ContentTest;
import com.pilgrim_lifestyle.model.event.content.DateOfTest;
import com.pilgrim_lifestyle.model.event.content.ExplanationTest;

@RunWith( value = Suite.class )
@SuiteClasses( value = {
        EventTest.class
        , EventDetailTest.class
        , EndDateTest.class
        , GuidelineTest.class
        , HeadCountTest.class
        , PeriodTest.class
        , StartDateTest.class
        , ContentTest.class
        , DateOfTest.class
        , ExplanationTest.class
        } )
public class AllTest
{

}
