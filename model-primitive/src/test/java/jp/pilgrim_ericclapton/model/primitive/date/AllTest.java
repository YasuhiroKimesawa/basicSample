package jp.pilgrim_ericclapton.model.primitive.date;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith( value = Suite.class )
@SuiteClasses( value = {
        DateStampTest.class
        , DateStampParsingTest.class
        , TimeStampTest.class
} )
public class AllTest
{

}
