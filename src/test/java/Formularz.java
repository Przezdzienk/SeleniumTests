import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Formularz extends Base{

    static WebElement continueButton;
    WebElement errorBox;
    static WebElement firstNameBox;
    static WebElement lastNameBox;
    static WebElement zipPostalCodeBox;
    WebElement subPageTitleText;
    WebElement finishButton;
    WebElement endImage;

    @BeforeEach
    public void prep(){
        Logowanie.logInIn();
        StronaGlowna.addAdd();
        Kosz.cartGo();
        Kosz.checkoutGo();
    }

    @Test
    public void noFilledData(){
        continueClick();
        errorBox=driver.findElement(By.className("error-message-container"));
        Assert.assertTrue(errorBox.isDisplayed());
    }

    @Test
    public void noFirstName(){
        fileLastName();
        filePostalCode();
        continueClick();
        errorBox=driver.findElement(By.className("error-message-container"));
        Assert.assertEquals(errorBox.getText(),"Error: First Name is required");
    }

    @Test
    public void noLastName(){
        fileFirstName();
        filePostalCode();
        continueClick();
        errorBox=driver.findElement(By.className("error-message-container"));
        Assert.assertEquals(errorBox.getText(),"Error: Last Name is required");
    }

    @Test
    public void noPostalCodeName(){
        fileLastName();
        fileFirstName();
        continueClick();
        errorBox=driver.findElement(By.className("error-message-container"));
        Assert.assertEquals(errorBox.getText(),"Error: Postal Code is required");
    }

    @Test
    public void continueSucceeded(){
        fileFirstName();
        fileLastName();
        filePostalCode();
        continueClick();
        subPageTitleText=driver.findElement(By.className("title"));
        Assert.assertEquals(subPageTitleText.getText(),"CHECKOUT: OVERVIEW");
    }

    @Test
    public void finish(){
        continueSucceeded();
        finishButton=driver.findElement(By.id("finish"));
        finishButton.click();
        endImage=driver.findElement(By.className("pony_express"));
        Assert.assertTrue(endImage.isDisplayed());
    }

    public static void continueClick(){
        continueButton=driver.findElement(By.name("continue"));
        continueButton.click();
    }

    public static void fileFirstName(){
        firstNameBox=driver.findElement(By.id("first-name"));
        firstNameBox.sendKeys("TestoweImie");
    }

    public static void fileLastName(){
        lastNameBox=driver.findElement(By.id("last-name"));
        lastNameBox.sendKeys("TestoweNazwisko");
    }

    public static void filePostalCode(){
        zipPostalCodeBox=driver.findElement(By.id("postal-code"));
        zipPostalCodeBox.sendKeys("12345");
    }
}
