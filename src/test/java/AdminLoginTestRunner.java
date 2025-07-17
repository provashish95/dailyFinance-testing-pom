import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminLoginTestRunner extends Setup {

    @Test(priority = 1, description = "Admin can login successfully with valid email and password")
    public void doLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.adminLogin("admin@test.com", "admin123");

        String txtHeaderActual = driver.findElement(By.tagName("h2")).getText();
        String txtHeaderExpected = "Admin Dashboard";
        Assert.assertEquals(txtHeaderActual, txtHeaderExpected);
    }

    @Test(priority = 1, description = "Admin can logout successfully")
    public void logout() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.doLogout();
    }
}
