package pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.microsoft.playwright.Page;

import locators.Locators;

@Component
public class PageObject {
    
    @Autowired
    private Page page;
    
    public void openPage(String url) {
        page.navigate(url);
    }
    
    public boolean isLogoPresent() {
        return page.locator(Locators.LOGO_IMG).count() > 0;
    }
    
    public boolean isLogoVisible() {
        return page.locator(Locators.LOGO_IMG).isVisible();
    }
}