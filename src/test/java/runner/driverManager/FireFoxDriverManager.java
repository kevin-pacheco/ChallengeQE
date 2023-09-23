package runner.driverManager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxDriverManager extends DriverManager{

    @Override
    public void createDriver(){
        System.setProperty("webdriver.gecko.driver","src/test/resources/geckodriver/geckodriver.exe");
        driver = new FirefoxDriver();
    }

}
