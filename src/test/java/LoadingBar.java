import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class LoadingBar {

    public void waitForLoad() {
        try {
            $(".progress-pjax-loader-bar").should(appear, Duration.ofMillis(2000));
        } catch (Error error) {
            System.out.println("Ожидался прогресс бар загрузки, но он не появился!");
            return;
        }

        $("#loading-bar").should(disappear, Duration.ofSeconds(10));
        sleep(300);
    }

}
