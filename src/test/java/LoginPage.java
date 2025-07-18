import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "email")
    WebElement txtEmail;

    @FindBy(id = "password")
    WebElement txtPassword;

    @FindBy(css = "[type = submit]")
    WebElement btnElement;


    public  LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);

    }

    public void adminLogin(String email,String password){
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        btnElement.click();
    }
}
