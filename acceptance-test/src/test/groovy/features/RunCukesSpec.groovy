package features

import org.junit.runner.RunWith
import cucumber.junit.Cucumber
import geb.junit4.GebReportingTest

@RunWith(Cucumber.class)
@Cucumber.Options(format = ["pretty", "html:build/cucumber"])
class RunCukesSpec extends GebReportingTest {
}
