package hw6.steps;

import hw3.pages.IndexPage;
import hw4.data.User;
import io.cucumber.java.en.Given;
import utils.WebDriverSingleton;

public class GivenSteps {

    private IndexPage indexPage;

    @Given("I am on Index page")
    public void iAmOnIndexPage() {
        WebDriverSingleton.INSTANCE.getDriver().get("https://jdi-testing.github.io/jdi-light/index.html");
        indexPage = new IndexPage(WebDriverSingleton.INSTANCE.getDriver());
    }

    @Given("I login as username: {string} pass: {string}")
    public void iLoginOnIndexPage(String username, String pass) {
        indexPage.login(User
                .builder()
                .setPassword(pass)
                .setUsername(username)
                .build());
    }

    @Given("I go through the header menu Service -> Different Elements Page")
    public void iOpenDifferentElementsPageThroughHeaderOnIndexPage() {
        indexPage.goToDifferentElementsPage();
    }

    @Given("I go through the header menu Service -> User Table")
    public void iOpenUserTablePageThroughHeaderOnIndexPage() {
        indexPage.goToUserTablePage();
    }

}
