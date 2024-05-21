package se.reky.hakan.service;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
public class PlayerControllerTest {

    private ChromeDriver driver;

    @BeforeAll
    public static void init() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp () {
        driver = new ChromeDriver();
        //driver.get("http://localhost:8080/players");
    }

    @AfterEach
    public void tearDown () {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void shouldReturnAmountOfPlayers () {
        driver.get("http://localhost:8080/players");
        List<WebElement> elements = driver.findElements(By.tagName("li"));

        assertEquals(2, elements.size());
    }

    @Test
    public void shouldReturnTrueIfPlayerIsDisplayed () {
        driver.get("http://localhost:8080/players");
        WebElement element = driver.findElement(By.tagName("li"));

        assertTrue(element.isDisplayed());
    }

    @Test
    public void shouldReturnTitleString () {
        driver.get("http://localhost:8080/players");
        String element = driver.getTitle();

        assertEquals("Players List", element);
    }

    @Test
    public void shouldReturnButtonString () {
        driver.get("http://localhost:8080/players");
        WebElement element = driver.findElement(By.tagName("button"));

        assertEquals("Logga in", element.getText());

    }

    @Test
    public void shouldReturnPlayerNameOnClickedEndPoint () {
        driver.get("http://localhost:8080/players");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        List <WebElement> elements = driver.findElements(By.tagName("a"));

        elements.get(0).click();

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));

        assertTrue(element.isDisplayed());

        //top player has name "Håkan" and 119 experience
        assertEquals("Håkan", element.getText());

    }

    @Test
    public void shouldReturnExpOnClickedEndPoint () {
        driver.get("http://localhost:8080/players");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        List <WebElement> elements = driver.findElements(By.tagName("a"));

        elements.get(0).click();

        List<WebElement> webElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("span")));

        webElements.get(2);

        assertEquals("119", webElements.get(2).getText());

    }


}
