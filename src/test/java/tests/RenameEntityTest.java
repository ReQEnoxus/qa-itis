package tests;

import base.TestBase;
import dto.Account;
import org.junit.Assert;

public class RenameEntityTest extends TestBase {
    @Override
    public void testCase() {
        // auth
        Account testAccount = new Account("yajanah653@glenwoodave.com", "qwerty123");

        app.window().resize(928, 694);
        app.navigation().navigateTo("/");
        app.auth().authWith(testAccount);

        // rename
        String testName = "New Name";
        app.navigation().navigateTo("/app");
        app.note().renameLastNoteWith(testName);

        Assert.assertEquals(app.note().lastCreatedNote().getContent(), testName);

        app.auth().logout();
    }
}
