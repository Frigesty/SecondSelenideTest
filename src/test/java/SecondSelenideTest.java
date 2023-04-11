import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class SecondSelenideTest {

    @Test
    void findSolutionsTest (){
        open("https://github.com");
        $(Selectors.byTagAndText("button", "Solutions")).hover();
        $(Selectors.byTagAndText("a", "Enterprize")).hover();
        $(".application-main ").shouldHave(Condition.text("Build like the best"));

    }

    @Test
    void moveActionsTestFall (){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        SelenideElement columnA = $("#column-a");
        SelenideElement columnB = $("#column-b");
        actions().clickAndHold(columnA).moveToElement(columnB).release().perform();
        columnA.shouldHave(Condition.text("B"));
        columnB.shouldHave(Condition.text("A"));
        Configuration.holdBrowserOpen = true;
    }


    @Test
    void dragDropTest () {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        SelenideElement columnA = $("#column-a");
        SelenideElement columnB = $("#column-b");
        columnA.shouldHave(Condition.text("A"));
        columnB.shouldHave(Condition.text("B"));
        columnA.dragAndDropTo("#column-b");
        columnA.shouldHave(Condition.text("B"));
        columnB.shouldHave(Condition.text("A"));
        Configuration.holdBrowserOpen = true;
    }
}
