package tests;

import base.AuthBase;
import dto.Folder;
import generator.DataGenerator;
import org.junit.Assert;

public class CreateAnotherEntityTest extends AuthBase {
    private Folder testFolder;

    @Override
    public void additionalSetup() {
        testFolder = DataGenerator.readFolder("folder.json");
    }

    @Override
    public void testCase() {
        super.testCase();

        // entity creation
        app.navigation().navigateTo("/app");
        app.folder().newWith(testFolder);

        Folder createdFolder = app.folder().lastCreatedFolder();
        Assert.assertEquals(testFolder.getName(), createdFolder.getName());
    }
}
