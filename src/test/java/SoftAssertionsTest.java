import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionsTest {

    @BeforeEach
    void beforeAll(){
        clearBrowserCookies();
        Configuration.baseUrl = "https://github.com/";
        Configuration.browserSize = "1590x850";
        open("");
    }

    @AfterAll
    static void afterAll(){
        closeWebDriver();
    }

    @RepeatedTest(20)
    void softAssertionsTest(){
        $("[data-test-selector='nav-search-input']").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("a[id='wiki-tab']").click();
        $(".js-wiki-more-pages-link").click();
        new LoadingBar().waitForLoad();
        $("[data-filterable-for='wiki-pages-filter']").$(byText("SoftAssertions")).click();

        $(byText("Using JUnit5 extend test class:")).parent().sibling(0).shouldHave(text("@ExtendWith({SoftAssertsExtension.class})"));
    }
}
