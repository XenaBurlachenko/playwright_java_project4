package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Класс для запуска Cucumber тестов.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",  
    glue = "steps",
    plugin = {"pretty"}
)
public class RunCucumberTest {
}