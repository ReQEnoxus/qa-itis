package tests;

import base.TestBase;
import dto.Account;
import dto.Folder;

public class CreateAnotherEntityTest extends TestBase {
    @Override
    public void testCase() {
        // login
        Account testAccount = new Account("yajanah653@glenwoodave.com", "qwerty123");

        app.window().resize(928, 694);
        app.navigation().navigateTo("/");
        app.login().authWith(testAccount);

        // entity creation
        Folder testFolder = new Folder("Sample Folder");
        app.navigation().navigateTo("/app");
        app.folder().newWith(testFolder);
    }
}
