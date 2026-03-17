package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

@Configuration
public class PlaywrightConfig {

    @Bean
    @Lazy
    @Scope("prototype")
    public Playwright playwright() {
        return Playwright.create();
    }

    @Bean
    @Lazy
    @Scope("prototype")
    public Browser browser(Playwright playwright) {
        return playwright.chromium().launch(new BrowserType.LaunchOptions()
            .setHeadless(true)
            .setDownloadsPath(null));  // отключаем загрузки
    }

    @Bean
    @Lazy
    @Scope("prototype")
    public BrowserContext browserContext(Browser browser) {
        return browser.newContext(new Browser.NewContextOptions()
            .setViewportSize(1280, 720));  // фиксированный размер
    }

    @Bean
    @Lazy
    @Scope("prototype")
    public Page page(BrowserContext browserContext) {
        return browserContext.newPage();
    }
}