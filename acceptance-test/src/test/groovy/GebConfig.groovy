import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver

driver = {
   // user chrome
   //System.setProperty("webdriver.chrome.driver","./src/test/groovy/chromedriver.exe");
   //new ChromeDriver()
    new FirefoxDriver()
}


waiting {
    timeout = 30
}