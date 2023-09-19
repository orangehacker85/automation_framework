package org.frontEnd.model;

import java.util.List;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Arrays;



public class PracticeSheet {
    @Test
    public void DropDowns() throws InterruptedException {
        System.setProperty("chromedriver", "/home/iwave85-e14/Documents/Courses/Automation/chromedriver-linux64");
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        WebElement staticDropdown=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticDropdown); //dropdown with select tag
        dropdown.selectByIndex(3);
        System.out.println(dropdown.getFirstSelectedOption().getText());
//        driver.navigate().refresh();
//        Thread.sleep(1000);
        dropdown.selectByVisibleText("AED");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
        Thread.sleep(2000);
        for(int i=1; i<5; i++) { driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click(); }
        driver.findElement(By.xpath("//input[@id='btnclosepaxoption']")).click();

        // dropdowns loaded based upon user actions are called dynamic dropdowns.
//        driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
        // in case we're asked to avoid using indexes, we can use a parent-child relationship locator
//        driver.findElement(By.xpath("//span[@id='ctl00_mainContent_ddl_destinationStation1_CTXTaction']//a[@value='MAA']")).click();
        driver.findElement((By.xpath("//input[@id='autosuggest']"))).sendKeys("aus");
        Thread.sleep(3000);
        List<WebElement> options=driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for(WebElement option : options) {
            if(option.getText().equalsIgnoreCase("Austria")) {
                option.click();
                break;
            }
        }
        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).click();
        System.out.println(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size()); // count the number of checkboxes

        // assertions
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='divpaxinfo']")).getText(), "5 Adult");
        driver.close();
    }

    @Test
    public void FunctionalTesting() throws InterruptedException {
        System.setProperty("chromedriver", "/home/iwave85-e14/Documents/Courses/Automation/chromedriver-linux64");
        WebDriver driver=new ChromeDriver();
        String[] itemsNeeded={"Cucumber", "Brocolli", "Beetroot"};
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        Thread.sleep(3000);
        addItems(driver,itemsNeeded);
        Thread.sleep(1000);
        driver.close();
    }

    public static void addItems(WebDriver driver,String[] itemsNeeded) {
        int j=0;
        List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
        System.out.println(products);
        System.out.println(products.size());
        for(int i=0; i<products.size(); i++) {
            String[] name=products.get(i).getText().split("-");
            String formattedName=name[0].trim();
            //format it to get actual vegetable name
            //convert array into array list for easy search
            //  check whether name you extracted is present in arrayList or not-
            List itemsNeededList=Arrays.asList(itemsNeeded);
            System.out.println(name);
            System.out.println(formattedName);
            System.out.println(itemsNeededList);
            if(itemsNeededList.contains(formattedName)) {
                j++;
                //click on Add to cart
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if(j==itemsNeeded.length) { break; }
            }
        }
    }

}
