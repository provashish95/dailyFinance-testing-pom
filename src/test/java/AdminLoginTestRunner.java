import org.testng.annotations.Test;

public class AdminLoginTestRunner extends Setup {


    @Test(priority = 1, description = "Admin can login successfully with valid email and password")
    public void doLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.adminLogin("admin@test.com", "admin123");
    }
}
