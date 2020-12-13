import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static io.restassured.RestAssured.given;

public class Logowanie extends Base {

    WebElement nazwa;
    WebElement password;
    WebElement logout;
    WebElement logInButton;
    WebElement errorMessage;

    @BeforeEach
    public void loginSet(){
        given().get(WebSite).then().statusCode(200);
        nazwa=driver.findElement(By.id("user-name"));
        password=driver.findElement(By.id("password"));
        logInButton=driver.findElement(By.id("login-button"));
    }

    @Test
    public void logIn(){

        nazwa.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        logInButton.click();

        Assert.assertTrue(driver.findElement(By.className("app_logo")).isDisplayed());
    }

    @Test
    public void logInFailNoPassWord(){
        nazwa.sendKeys("standard_user");
        logInButton.click();

        errorMessage=driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/form/h3"));
        Assert.assertEquals("Epic sadface: Password is required",errorMessage.getText());
    }

    @Test
    public void logInFailWrongPassWord(){
        nazwa.sendKeys("standard_user");
        password.sendKeys("CosMaggicznego");
        logInButton.click();

        errorMessage=driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/form/h3"));
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service",errorMessage.getText());
    }
    @Test
    public void logInFailUsersRestrictions(){
        nazwa.sendKeys("locked_out_user");
        password.sendKeys("secret_sauce");
        logInButton.click();

        errorMessage=driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/form/h3"));
        Assert.assertEquals("Epic sadface: Sorry, this user has been locked out.",errorMessage.getText());
    }
    @Test
    public void logOut(){

        logIn();
        driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/button")).click();

        logout=driver.findElement(By.linkText("Logout"));
        Assert.assertTrue(logout.isDisplayed());
        logout.click();
    }


}
