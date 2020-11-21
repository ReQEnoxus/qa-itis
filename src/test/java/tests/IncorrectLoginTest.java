package tests;

import base.TestBase;
import dto.Account;
import generator.DataGenerator;
import org.junit.Assert;

public class IncorrectLoginTest extends TestBase {
    private Account testAccount;

    @Override
    public void additionalSetup() {
        testAccount = DataGenerator.readAccount("incorrectAccount.json");
    }

    @Override
    public void testCase() {
        if (app.auth().isLoggedIn()) {
            app.auth().logout();
        }
        app.navigation().navigateTo("/");
        app.auth().authWith(testAccount);

        Assert.assertFalse(app.auth().isLoggedIn());
    }
}
