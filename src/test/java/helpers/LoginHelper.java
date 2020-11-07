package helpers;

import dto.Account;
import manager.ApplicationManager;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class LoginHelper extends HelperBase {

    public LoginHelper(ApplicationManager manager) {
        super(manager);
    }

    public void authWith(Account account) {
        manager.driver().findElement(By.name("username")).sendKeys(account.getEmail());
        manager.driver().findElement(By.name("password")).sendKeys(account.getPassword());
        manager.driver().findElement(By.name("login")).click();
    }

    public void logout() {
        manager.driver().findElement(By.id("username")).click();
        manager.driver().findElement(By.id("sign-out")).click();
        manager.driver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public String authenticatedEmail() {
        return manager.driver().findElement(By.id("username")).getText();
    }
}
