package week2.day1;

import java.sql.DriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		//String path = System.getProperty("webdriver.chrome.driver");
		//System.out.println(path);
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();

		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("CompanyName");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Joe");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Layes");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("FirstnameLocal");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("createLeadForm_departmentName");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("email@gmail.com");
		
		
		WebElement source=driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select dd=new Select(source);
		dd.selectByValue("LEAD_CONFERENCE");
		
		WebElement state=driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select sdd=new Select(state);
		sdd.selectByVisibleText("New York");
		
		
		driver.findElement(By.name("submitButton")).click();
		
		String title = driver.getTitle();
		System.out.println(title);
		
		
		
		
		

	}

}
