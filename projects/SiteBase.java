package projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SiteBase extends Modules {
	String address = "http://demo.guru99.com/v4/";

	void url() {
		driver.get(address);
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
	}

	String id;
	String pass;

	void signup() {
		driver.findElement(By.linkText("here")).click();
		;
		driver.findElement(By.xpath("//tbody/tr[5]/td[2]/input[1]")).sendKeys("happy@newmail.com");
		driver.findElement(By.xpath("//tbody/tr[6]/td[2]/input[1]")).click();
		id = driver.findElement(By.xpath("//td[contains(text(),'mngr313440')]")).getText();
		System.out.println(id);
		pass = driver.findElement(By.xpath("//td[contains(text(),'ybabUdy')]")).getText();
		System.out.println(pass);
		System.out.println("Signup is done");
	}

	void login() {
		driver.get(address);
		driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]")).sendKeys(id);
		driver.findElement(By.xpath("//tbody/tr[2]/td[2]/input[1]")).sendKeys(pass);
		driver.findElement(By.xpath("//tbody/tr[3]/td[2]/input[1]")).click();
		System.out.println("Login is done");
	}

	void close() {
		driver.close();
		System.out.println("Program End");
	}
}

class Modules {
	WebDriver driver = new ChromeDriver();
	String cid;
	void newCustomer() throws InterruptedException {
		driver.findElement(By.xpath("//a[contains(text(),'New Customer')]")).click();
		driver.findElement(By.xpath("//tbody/tr[4]/td[2]/input[1]")).sendKeys("Kinderjoy");
		driver.findElement(By.xpath("//tbody/tr[5]/td[2]/input[1]")).click();
		driver.findElement(By.xpath("//input[@id='dob']")).sendKeys("25061995");
		driver.findElement(By.xpath("//tbody/tr[7]/td[2]/textarea[1]"))
				.sendKeys("new" + "adress 5 2 31 street 3 new world");
		driver.findElement(By.xpath("//tbody/tr[8]/td[2]/input[1]")).sendKeys("new city");
		driver.findElement(By.xpath("//tbody/tr[9]/td[2]/input[1]")).sendKeys("new state");
		driver.findElement(By.xpath("//tbody/tr[10]/td[2]/input[1]")).sendKeys("123456");
		driver.findElement(By.xpath("//tbody/tr[11]/td[2]/input[1]")).sendKeys("9876543210");
		driver.findElement(By.xpath("//tbody/tr[12]/td[2]/input[1]")).sendKeys("abcd@efgh.mno");
		driver.findElement(By.xpath("//tbody/tr[13]/td[2]/input[1]")).sendKeys("asdfghjkl");
		driver.findElement(By.xpath("//tbody/tr[14]/td[2]/input[1]")).click();
		System.out.println("New Customer page is done");
		Thread.sleep(2000);
		String res = driver.findElement(By.xpath("//p[contains(text(),'Customer Registered"
				+ " Successfully!!!')]")).getText();
		System.out.println(res);
		cid = driver.findElement(By.xpath("//tbody/tr[4]/td[2]")).getText();
		System.out.println(cid);
	}
	void editCustomer() {
		System.out.println("Customer Editing");
		driver.findElement(By.xpath("//a[contains(text(),'Edit Customer')]")).click();
		driver.findElement(By.xpath("//tbody/tr[6]/td[2]/input[1]")).sendKeys(cid);
		driver.findElement(By.xpath("//tbody/tr[11]/td[2]/input[1]")).click();
		driver.findElement(By.xpath("//tbody/tr[10]/td[2]/input[1]")).clear();
		driver.findElement(By.xpath("//tbody/tr[10]/td[2]/input[1]")).sendKeys("874563");
		driver.findElement(By.xpath("//tbody/tr[13]/td[2]/input[1]")).click();
		System.out.println("Customer Edited");
	}
	void deleteCustomer() {
		driver.findElement(By.xpath("//body/div[3]/div[1]/ul[1]/li[4]/a[1]")).click();
		driver.findElement(By.xpath("//tbody/tr[2]/td[2]/input[1]")).sendKeys(cid);
		driver.findElement(By.xpath("//tbody/tr[7]/td[2]/input[1]")).click();
		System.out.println("Customer Deleted");
	}

}
