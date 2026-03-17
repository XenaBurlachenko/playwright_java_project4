package tests;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.microsoft.playwright.Page;

import config.PlaywrightConfig;
import pages.PageObject;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {PlaywrightConfig.class, PageObject.class})
public class LogoTest {

    @Autowired
    private PageObject pageObject;
    
    @Autowired
    private Page page;

    @Test
    public void testLogo() {
        pageObject.openPage("https://algosstile.github.io/vue-app/index.html");
        
        boolean logoExists = pageObject.isLogoPresent();
        assertTrue("Логотип должен присутствовать на странице", logoExists);
        
        boolean logoVisible = pageObject.isLogoVisible();
        assertTrue("Логотип должен быть виден", logoVisible);
    }
}