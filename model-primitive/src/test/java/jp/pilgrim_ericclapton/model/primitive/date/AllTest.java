package jp.pilgrim_ericclapton.model.primitive.date;

import jp.pilgrim_ericclapton.model.primitive.date.format.DateStampFormatTest;
import jp.pilgrim_ericclapton.model.primitive.date.format.TimeStampFormatTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith( value = Suite.class )
@SuiteClasses( value = {
        DateStampTest.class
        , DateStampParsingTest.class
        , TimeStampTest.class
        , DateStampFormatTest.class
        , TimeStampFormatTest.class
} )
public class AllTest
{

}
