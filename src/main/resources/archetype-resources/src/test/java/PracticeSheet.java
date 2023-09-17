package $package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeSheet {
    
    @Test
    public void WebElAutomation() {
        System.setProperty("chromedriver", "/home/iwave85-e14/Documents/Courses/Automation/chromedriver-linux64");
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        Select dropdown=new Select(); //dropdown with select tag
        

    }
}
