package testRunner;

import com.github.javafaker.Faker;
import config.Setup;
import config.UserModel;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.SignUpPage;
import utils.Util;

import java.io.IOException;

public class SignupTestRunner extends Setup {

    @Test(priority = 1, description = "User registration complete", enabled = false)
    public void doSignup() throws IOException, ParseException {
        driver.findElement(By.partialLinkText("Register")).click();
        SignUpPage signUpPage = new SignUpPage(driver);

        //Create fake random data by Java Faker
        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = "provashishroy" + Util.generateRandomNumber(100, 999) + "@gmail.com";
        String password = "1234";
        String phoneNumber = "0163" + Util.generateRandomNumber(10000000, 99999999);
        String address = faker.address().fullAddress();

        UserModel userModel = new UserModel();

        userModel.setFirstName(firstName);
        userModel.setLastName(lastName);
        userModel.setEmail(email);
        userModel.setPassword(password);
        userModel.setPhoneNumber(phoneNumber);
        userModel.setAddress(address);

        signUpPage.signup(userModel);

        //Save users data to json file
        Util.saveUserData(firstName, lastName, email, password, phoneNumber, address);
    }

    @Test(priority = 2, description = "User can registration without optional data")
    public void doSignupWithoutOptional() throws IOException, ParseException {
        driver.findElement(By.partialLinkText("Register")).click();
        SignUpPage signUpPage = new SignUpPage(driver);

        //Create fake random data by Java Faker
        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = "provashishroy" + Util.generateRandomNumber(100, 999) + "@gmail.com";
        String password = "1234";
        String phoneNumber = "0163" + Util.generateRandomNumber(10000000, 99999999);
        String address = faker.address().fullAddress();

        UserModel userModel = new UserModel();

        userModel.setFirstName(firstName);
        // userModel.setLastName(lastName);
        userModel.setEmail(email);
        userModel.setPassword(password);
        userModel.setPhoneNumber(phoneNumber);
        //userModel.setAddress(address);

        signUpPage.signup(userModel);

        //Save users data to json file
        //Util.saveUserData(firstName, lastName, email, password, phoneNumber, address);
    }
}
