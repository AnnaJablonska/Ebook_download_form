import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ResourcesPage {

    private WebDriver driver;
    private Faker faker;
    private String url = "https://www.tivix.com/resources/tivix-guide-to-design-thinking";

    public ResourcesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(url);
    }


    public void orderingFreeEbookWithCorrectData(String firstName, String lastName, String company){

        driver.findElement(By.linkText("Agree and close")).click();

//        WebDriverWait wait = new WebDriverWait(driver, 60);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Field2")));

        driver.switchTo().frame(1);

        driver.findElement(By.id("Field2")).click();
        driver.findElement(By.id("Field2")).clear();
        driver.findElement(By.id("Field2")).sendKeys(firstName);

        driver.findElement(By.id("Field3")).click();
        driver.findElement(By.id("Field3")).clear();
        driver.findElement(By.id("Field3")).sendKeys(lastName);

        driver.findElement(By.id("Field12")).clear();
        driver.findElement(By.id("Field12")).sendKeys(company);

        Faker faker = new Faker();
        String email = faker.internet().emailAddress();

        driver.findElement(By.id("Field5")).click();
        driver.findElement(By.id("Field5")).clear();
        driver.findElement(By.id("Field5")).sendKeys(email);

        driver.findElement(By.id("Field29")).click();

        driver.findElement(By.id("saveForm")).click();
    }

    public void orderingFreeEbookWithInvalidData(String firstName, String lastName, String company){

        driver.findElement(By.linkText("Agree and close")).click();

        driver.switchTo().frame(1);

        driver.findElement(By.id("Field2")).click();
        driver.findElement(By.id("Field2")).clear();
        driver.findElement(By.id("Field2")).sendKeys(firstName);

        driver.findElement(By.id("Field3")).click();
        driver.findElement(By.id("Field3")).clear();
        driver.findElement(By.id("Field3")).sendKeys(lastName);

        driver.findElement(By.id("Field12")).clear();
        driver.findElement(By.id("Field12")).sendKeys(company);

        driver.findElement(By.id("Field29")).click();

        driver.findElement(By.id("saveForm")).click();
    }

}
