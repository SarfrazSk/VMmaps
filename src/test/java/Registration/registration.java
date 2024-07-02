package demo.com.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginOBJ {
	
WebDriver ldriver;
	
	public LoginOBJ(WebDriver driver) {
		ldriver= driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(how=How.ID,using="email")
	@CacheLookup
	public 
	WebElement email_fill; 
	
	@FindBy(how=How.ID,using="pass")
	@CacheLookup
	public 
	WebElement pwd_fill; 
	
	@FindBy(how=How.ID,using="loginSubmit")
	@CacheLookup
	public 
	WebElement login_btn; 
	

}
