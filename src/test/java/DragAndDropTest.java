import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @BeforeAll
    static void beforeAll(){
        clearBrowserCookies();
        Configuration.baseUrl = "https://the-internet.herokuapp.com/";
        Configuration.browserSize = "1590x850";
    }

    @AfterAll
    static void afterAll(){
        closeWebDriver();
    }

    @Test
    void dragAndDrop(){
        open("/drag_and_drop");
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
