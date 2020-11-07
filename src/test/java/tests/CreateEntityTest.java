package tests;// Generated by Selenium IDE

import base.TestBase;
import dto.Account;
import dto.Note;
import org.junit.Assert;

public class CreateEntityTest extends TestBase {
    @Override
    public void testCase() {
        // auth
        Account testAccount = new Account("yajanah653@glenwoodave.com", "qwerty123");

        app.window().resize(928, 694);
        app.navigation().navigateTo("/");
        app.auth().authWith(testAccount);

        // entity creation
        Note testNote = new Note("Sample Text");
        app.navigation().navigateTo("/app");
        app.note().newWith(testNote);
        Note createdNote = app.note().lastCreatedNote();

        Assert.assertEquals(testNote.getContent(), createdNote.getContent());

        app.auth().logout();
    }
}
