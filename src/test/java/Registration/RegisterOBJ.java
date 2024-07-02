package Registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegisterOBJ {

    WebDriver ldriver;

    public RegisterOBJ(WebDriver driver) {
        ldriver= driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(how=How.ID,using="Name")
    @CacheLookup
    public
    WebElement name_fill;

    @FindBy(how=How.ID,using="email")
    @CacheLookup
    public
    WebElement email_fill;

    @FindBy(how=How.XPATH,using="//input[@class='PhoneInputInput']")
    @CacheLookup
    public
    WebElement phonenumber_fill;


    @FindBy(how=How.ID,using="password")
    @CacheLookup
    public
    WebElement pwd_fill;


    @FindBy(how=How.ID,using="registerSubmit")
    @CacheLookup
    public
    WebElement register_fbtn;

    @FindBy(how=How.XPATH,using="//h3[text()='Please Enter Password']")
    @CacheLookup
    public
    WebElement err_msg_pwd;

    @FindBy(how=How.XPATH,using="//h3[text()='Please Enter Phone']")
    @CacheLookup
    public
    WebElement err_msg_ph;

    @FindBy(how=How.XPATH,using="//h3[text()='Please Enter Name']")
    @CacheLookup
    public
    WebElement err_msg_name;

    @FindBy(how=How.XPATH,using="//h3[text()='Please Enter Valid Email']")
    @CacheLookup
    public
    WebElement err_msg_email;

    @FindBy(how=How.XPATH,using="//*[text()='Password must contain a small case capital case  a number and a symbol']")
    @CacheLookup
    public
    WebElement err_msg_invaild_pwd;


}