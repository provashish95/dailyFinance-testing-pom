package testRunner;

import com.github.javafaker.Faker;
import config.Setup;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.SignUpPage;
import utils.Util;

import java.io.IOException;

public class SignupTestRunner extends Setup {

    @Test(priority = 1, description = "User registration complete")

    public void doSignup() throws IOException, ParseException {
        driver.findElement(By.partialLinkText("Register")).click();
        SignUpPage signUpPage = new SignUpPage(driver);

        //Create fake random data by Java Faker
        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = "provashishroy"+ Util.generateRandomNumber(100,999)+"@gmail.com";
        String password = "1234";
        String phoneNumber = "0163"+ Util.generateRandomNumber(10000000, 99999999);
        String address =  faker.address().fullAddress();

        signUpPage.signup(firstName, lastName, email, password, phoneNumber, address);

        //Save users data to json file
        Util.saveUserData(firstName, lastName, email, password, phoneNumber, address);
    }
}
