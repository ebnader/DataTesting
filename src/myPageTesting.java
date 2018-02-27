import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class myPageTesting {
	
	WebDriver driver;
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("file:///C:/Users/ebnad/Google%20Drive/Html%20Page/MYWEBPAGE.html");
		
		String[][] data=ReadData.getData("Mercurydata.xlsx", "sheet1");
		
		for(int i=1;i<data.length;i++){
			String username=data[i][0];
			String password=data[i][1];
			driver.findElement(By.xpath("//input[@name='userid']")).clear();
			driver.findElement(By.xpath("//input[@name='userid']")).sendKeys(username);
			driver.findElement(By.xpath("//input[@name='psw']")).clear();
			driver.findElement(By.xpath("//input[@name='psw']")).sendKeys(password);
			
			driver.findElement(By.xpath("//button[@type='button']")).click();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			
			
		}
		
		driver.quit();
	}

}
