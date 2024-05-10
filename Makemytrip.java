package SeleniumTesting;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Makemytrip {
	
@Test
	
public void searchflights() {
	
//Launch Edge
WebDriverManager.edgedriver().setup();
EdgeDriver driver = new EdgeDriver();
	
// Enter URL
driver.get("https://www.makemytrip.com/");
    
//Implicit Wait
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
//Maximize Window
driver.manage().window().maximize();
	
//closeicon
WebElement closeicon =driver.findElement((By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div[2]/div/section/span")));
closeicon.click();
	
//Select RoundTrip
WebDriverWait wait = new WebDriverWait(driver,10);
WebElement roundTrip = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@data-cy='roundTrip']")));
roundTrip.click();
	
//From Field
WebElement fromcityplace =  driver.findElement(By.id("fromCity"));
fromcityplace.click();
    
WebElement fromField = driver.findElement(By.xpath("//input[@placeholder='From']"));
fromField.sendKeys("Chennai");
fromField.sendKeys(Keys.ENTER);
  
Actions actions = new Actions(driver);
actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN) 
.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
.sendKeys(Keys.ENTER).build().perform();
   
//To Field
WebElement tofieldplace =  driver.findElement(By.id("toCity"));
tofieldplace.click();
  
WebElement toField = driver.findElement(By.xpath("//input[@placeholder='To']"));
toField.sendKeys("Bangkok");
toField.sendKeys(Keys.ENTER);
  
Actions actions1 = new Actions(driver);
actions1.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
   
//Start Date
WebElement startDate = driver.findElement(By.xpath("//*[@id=\'top-banner\']/div[2]/div/div/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[1]/div[5]/div/p"));
startDate.click();
   
//End Date
WebElement endDate = driver.findElement(By.xpath("//*[@id=\'top-banner\']/div[2]/div/div/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[4]/div[5]/div/p"));
endDate.click();
   
//travellersoption
WebElement travellersoption = driver.findElement(By.xpath("//label[@for='travellers']"));
travellersoption.click();
   
//select Adults
WebElement adults = driver.findElement(By.xpath("//li[@data-cy='adults-4']"));
adults.click();
   
//select children
WebElement children = driver.findElement(By.xpath("//li[@data-cy='children-2']"));
children.click();
   
//select infants
WebElement infants = driver.findElement(By.xpath("//li[@data-cy='infants-1']"));
infants.click();
   
//select business
WebElement business = driver.findElement(By.xpath("//li[@data-cy='travelClass-2']"));
business.click();
  
//select applybutton
WebElement applybutton = driver.findElement(By.xpath("//button[@data-cy='travellerApplyBtn']"));
applybutton.click();
   
//select options
WebElement armedForceOption= driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/div[4]"));
armedForceOption.click();
  
//click searchbutton
WebElement searchbutton = driver.findElement(By.xpath("//a[contains(@class,'widgetSearchBtn')]"));
searchbutton.click();
  
//click okbutton
WebElement okbutton = driver.findElement(By.xpath("//button[text()='OKAY, GOT IT!']"));
okbutton.click();
  
//title
String journeytitletext = driver.findElement(By.xpath("//p[contains(@class,'journey-title')]//span")).getText();
  
if(journeytitletext.equals("Flights from Chennai to Bangkok, and back")) 
{
	  System.out.println("Test Passed");
}
else 
{
	  System.out.println("Test Failed");
}

//Quit Browser
driver.quit();
}
}
