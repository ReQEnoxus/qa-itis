package tests;

import base.TestBase;
import dto.Account;
import dto.Note;
import generator.DataGenerator;
import org.junit.Assert;

public class RenameEntityTest extends TestBase {
    private Account testAccount;
    private Note testNote;

    @Override
    public void additionalSetup() {
        testAccount = DataGenerator.readAccount("account.json");
        testNote = DataGenerator.readNote("otherNote.json");
    }

    @Override
    public void testCase() {
        // auth
        app.window().resize(928, 694);
        app.navigation().navigateTo("/");
        app.auth().authWith(testAccount);

        // rename
        String testName = testNote.getContent();
        app.navigation().navigateTo("/app");
        app.note().renameLastNoteWith(testName);

        Assert.assertEquals(app.note().lastCreatedNote().getContent(), testName);

        app.auth().logout();
    }
}
