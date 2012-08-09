import org.openqa.selenium.chrome.ChromeDriver

//import org.openqa.selenium.firefox.FirefoxDriver


driver = {
   System.setProperty("webdriver.chrome.driver","./test/groovy/chromedriver.exe");
   // def driver = new FirefoxDriver()
}

environments {

    // grails -Dgeb.env=chrome test-app
    chrome {
        driver = { new ChromeDriver() }
    }

    // grails -Dgeb.env=firefox test-app
   // firefox {
    //    driver = { new FirefoxDriver() }
    //}
}