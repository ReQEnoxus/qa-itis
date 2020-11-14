package tests;

import base.TestBase;
import dto.Account;
import dto.Folder;
import generator.DataGenerator;
import org.junit.Assert;

public class CreateAnotherEntityTest extends TestBase {

    private Account testAccount;
    private Folder testFolder;

    @Override
    public void additionalSetup() {
        testAccount = DataGenerator.readAccount("account.json");
        testFolder = DataGenerator.readFolder("folder.json");
    }

    @Override
    public void testCase() {
        // auth
        app.window().resize(928, 694);
        app.navigation().navigateTo("/");
        app.auth().authWith(testAccount);

        // entity creation
        app.navigation().navigateTo("/app");
        app.folder().newWith(testFolder);

        Folder createdFolder = app.folder().lastCreatedFolder();
        Assert.assertEquals(testFolder.getName(), createdFolder.getName());

        app.auth().logout();
    }
}
