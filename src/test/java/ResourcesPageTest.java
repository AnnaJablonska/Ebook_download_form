import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ResourcesPageTest {

    private WebDriver driver;
    private ResourcesPage resourcePage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        resourcePage = new ResourcesPage(driver);
        resourcePage.open();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();

    }

    @Test
    public void userSubmitFormWithValidData(){
        resourcePage.orderingFreeEbookWithCorrectData("Anna", "Jablonska", "company");
    }


    @Test
    public void canNotSubmitFormWithInvalidData() {
        resourcePage.orderingFreeEbookWithInvalidData("Anna", "Jablonska", "company");
                Assert.assertEquals("Error with filling form. No email", "There was a problem with your submission.",
                        driver.findElement(By.id("errorMsgLbl")).getText());
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
        driver = null;
    }
}
