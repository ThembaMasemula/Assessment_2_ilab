package WebUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebUtilities {
    protected static WebDriver driver;
    public static WebDriver getWebdriver(){
        return driver;
    }

    public void setWebDriver(WebDriver DriverTest){
        this.driver = DriverTest;
    }

    public WebDriver initializeWebDriver(String Browser) {
        switch (Browser.toUpperCase()) {

            case "CHROME":

                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "IE":
                WebDriverManager.chromiumdriver().setup();
                driver = new EdgeDriver();
                break;
        }

        return driver;
    }

    public void navigate(String url){

        driver.get(url);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void CloseWindow(){
        try{
            Thread.sleep(2000);
            driver.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }
}
