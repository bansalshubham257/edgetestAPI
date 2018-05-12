package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SignInTest {

	WebDriver driver;
	
	public SignInTest(WebDriver driver){
        this.driver = driver;
    }

 
    public String shouldThrowAnErrorIfSignInDetailsAreMissing() {

        driver.findElement(By.linkText("Your trips")).click();
        driver.findElement(By.id("SignIn")).click();
        driver.findElement(By.id("signInButton")).click();
        String errors1 = driver.findElement(By.id("errors1")).getText();
        return errors1;
    }
}
