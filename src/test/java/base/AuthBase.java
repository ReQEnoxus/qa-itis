package base;

import generator.DataGenerator;

public abstract class AuthBase extends TestBase {

    @Override
    public void testCase() {
        while (!app.auth().isLoggedIn()) {
            app.navigation().navigateTo("/");
            app.auth().authWith(DataGenerator.readAccount("account.json"));
        }
    }
}
