import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SignupTestRunner extends Setup {

    @Test(priority = 1, description = "User registration complete")

    public void doSignup(){
        driver.findElement(By.partialLinkText("Register")).click();
        SignUpPage signUpPage = new SignUpPage(driver);

        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = "provashishroy"+Util.generateRandomNumber(100,999)+"@gmail.com";
        String password = "1234";
        String phoneNumber = "0163"+Util.generateRandomNumber(10000000, 99999999);
        String address =  faker.address().fullAddress();

        signUpPage.signup(firstName, lastName, email, password, phoneNumber, address);

    }
}
