import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionsTest {

    @BeforeAll
    static void beforeAll(){
        clearBrowserCookies();
        Configuration.baseUrl = "https://github.com/";
        Configuration.browserSize = "1590x850";
        open("");
    }

    @AfterAll
    static void afterAll(){
        closeWebDriver();
    }

    @Test
    void softAssertionsTest(){
        $("[data-test-selector='nav-search-input']").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("a[id='wiki-tab']").click();
        $(".js-wiki-more-pages-link").click();
        $("[data-filterable-for='wiki-pages-filter']").$(byText("SoftAssertions")).click();

        $(byText("Using JUnit5 extend test class:")).parent().sibling(0).shouldHave(text("@ExtendWith({SoftAssertsExtension.class})"));
    }
}
