package testRunner;

import com.github.javafaker.Faker;
import config.Setup;
import config.UserModel;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
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

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstName", firstName);
        jsonObject.put("lastName", lastName);
        jsonObject.put("email", email);
        jsonObject.put("password", password);
        jsonObject.put("phoneNumber", phoneNumber);
        jsonObject.put("address", address);

        //Save users data to json file
        Util.saveUserData(jsonObject, "./src/test/resources/users.json");
    }

    @Test(priority = 2, description = "User can registration without optional data")
    public void doSignupWithoutOptional() throws IOException, ParseException {
       // driver.findElement(By.partialLinkText("Register")).click();
        SignUpPage signUpPage = new SignUpPage(driver);

        //Create fake random data by Java Faker
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String email = "provashishroy" + Util.generateRandomNumber(100, 999) + "@gmail.com";
        String password = "1234";
        String phoneNumber = "0163" + Util.generateRandomNumber(10000000, 99999999);


        UserModel userModel = new UserModel();

        userModel.setFirstName(firstName);
        userModel.setEmail(email);
        userModel.setPassword(password);
        userModel.setPhoneNumber(phoneNumber);

        signUpPage.signup(userModel);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstName", firstName);
        jsonObject.put("email", email);
        jsonObject.put("password", password);
        jsonObject.put("phoneNumber", phoneNumber);

        //Save users data to json file
        Util.saveUserData(jsonObject, "./src/test/resources/users.json");
    }

    @AfterMethod
    public void navigateToSignupPage(){
        driver.navigate().to("https://dailyfinance.roadtocareer.net/register");
    }
}
