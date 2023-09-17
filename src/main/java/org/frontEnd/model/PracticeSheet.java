package org.frontEnd.model;

import com.sun.org.apache.bcel.internal.generic.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class PracticeSheet {
    @Test
    public void WebElAutomation() {
        System.setProperty("chromedriver", "/home/iwave85-e14/Documents/Courses/Automation/chromedriver-linux64");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
//        Select dropdown = new Select(); //dropdown with select tag


        }
}
