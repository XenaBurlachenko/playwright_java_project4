package steps;

import com.microsoft.playwright.Page;
import config.PlaywrightConfig;
import pages.PageObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import org.junit.Assert;
import io.cucumber.spring.CucumberContextConfiguration;

/**
 * Этот файл приводит человекочитаемый код в Java?
 */
@CucumberContextConfiguration
@ContextConfiguration(classes = {PlaywrightConfig.class, PageObject.class})
public class LogoTestSteps {

    /**
     * Spring сам создаст эти объекты?
     */
    @Autowired
    private PageObject pageObject;
    
    @Autowired
    private Page page;

    /**
     * Этот метод соответствует строке "I open the test page" в .feature файле
     */
    @Given("I open the test page")
    public void iOpenTheTestPage() {
        // Используем PageObject чтобы открыть страницу
        // Не работаем напрямую с Playwright - все скрыто внутри PageObject?
        pageObject.openPage("https://algosstile.github.io/vue-app/index.html");
        System.out.println("Страница открыта");
    }

    /**
     * Этот метод соответствует строке "I check for the logo"
     * 
     * @When - действие, которое проверяем (найти логотип)
     */
    @When("I check for the logo")
    public void iCheckForTheLogo() {
        // Спрашиваем у PageObject, есть ли логотип
        boolean logoExists = pageObject.isLogoPresent();
        
        // Assert - проверка. Если logoExists == false, тест упадет с сообщением
        Assert.assertTrue("❌ Логотип НЕ найден на странице!", logoExists);
        System.out.println("✓ Логотип найден на странице");
    }

    /**
     * Этот метод соответствует строке "I verify the logo is displayed"
     * 
     * @Then - проверка результата (убедиться что логотип виден)
     */
    @Then("I verify the logo is displayed")
    public void iVerifyTheLogoIsDisplayed() {
        // Проверяем видимость логотипа
        boolean logoVisible = pageObject.isLogoVisible();
        
        Assert.assertTrue("❌ Логотип есть, но он НЕ видим пользователю!", logoVisible);
        System.out.println("✓ Логотип видим пользователю");
        System.out.println("✅ Тест успешно завершен!");
    }
}
