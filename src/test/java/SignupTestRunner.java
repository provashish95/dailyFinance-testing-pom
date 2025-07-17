import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SignupTestRunner extends Setup {

    @Test(priority = 1, description = "User registration complete")

    public void doSignup(){
        driver.findElement(By.partialLinkText("Register")).click();
        SignUpPage signUpPage = new SignUpPage(driver);

        String firstName = "Provashish";
        String lastName = "Roy";
        String email = "provashish@gmail.com";
        String password = "1234";
        String phoneNumber = "01632544810";
        String address =  "Dhaka";

        signUpPage.signup(firstName, lastName, email, password, phoneNumber, address);

    }
}
