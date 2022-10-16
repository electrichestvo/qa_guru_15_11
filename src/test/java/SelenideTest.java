import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "2560x1440";
    }

    @Test
    void shouldFindSelenideRepositoryAtFirstPlace(){
            open("https://github.com/selenide/selenide");
            $("#wiki-tab").click();
            $("#wiki-pages-filter").setValue("SoftAssertions").pressEnter();
            $$(".details-reset").findBy(visible).shouldBe(text("SoftAssertions")).click();
            $(".Layout-main").$(byText("3. Using JUnit5 extend test class:")).shouldBe(text("3. Using JUnit5 extend test class:"));
        }
    }