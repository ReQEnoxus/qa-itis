package tests;

import base.AuthBase;
import dto.Note;
import generator.DataGenerator;
import org.junit.Assert;

public class RenameEntityTest extends AuthBase {
    private Note testNote;

    @Override
    public void additionalSetup() {
        testNote = DataGenerator.readNote("otherNote.json");
    }

    @Override
    public void testCase() {
        super.testCase();

        // rename
        String testName = testNote.getContent();
        app.navigation().navigateTo("/app");
        app.note().renameLastNoteWith(testName);

        Assert.assertEquals(app.note().lastCreatedNote().getContent(), testName);
    }
}
