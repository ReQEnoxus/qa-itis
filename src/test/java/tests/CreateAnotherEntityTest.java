package tests;

import base.TestBase;
import dto.Account;
import dto.Folder;
import org.junit.Assert;

public class CreateAnotherEntityTest extends TestBase {
    @Override
    public void testCase() {
        // auth
        Account testAccount = new Account("yajanah653@glenwoodave.com", "qwerty123");

        app.window().resize(928, 694);
        app.navigation().navigateTo("/");
        app.auth().authWith(testAccount);

        // entity creation
        Folder testFolder = new Folder("Sample Folder");
        app.navigation().navigateTo("/app");
        app.folder().newWith(testFolder);

        Folder createdFolder = app.folder().lastCreatedFolder();
        Assert.assertEquals(testFolder.getName(), createdFolder.getName());

        app.auth().logout();
    }
}
