import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Kosz extends Base{

    WebElement logo;
    WebElement removeButton;
    WebElement cartLink;
    WebElement continueShoppingButton;
    List<WebElement> itemInCart;
    List<WebElement> removedItemsFromCart;

    @BeforeEach
    public void Prep(){
        Logowanie.logInIn();
    }

    @Test
    public void checkAddedItems(){
        StronaGlowna.addAdd();
        cartLink=driver.findElement(By.className("shopping_cart_link"));
        cartLink.click();
        itemInCart=driver.findElements(By.className("cart_item"));
        Assert.assertTrue(itemInCart.size()==2);
    }

    @Test
    public void checkIfNoAddedItems(){
        cartLink=driver.findElement(By.className("shopping_cart_link"));
        cartLink.click();
        itemInCart=driver.findElements(By.className("cart_item"));
        Assert.assertTrue(itemInCart.size()==0);
    }

    @Test
    public void removeItems(){
        StronaGlowna.addAdd();
        cartLink=driver.findElement(By.className("shopping_cart_link"));
        cartLink.click();
        removeButton= driver.findElement(By.id("remove-sauce-labs-bike-light"));
        removeButton.click();
        itemInCart=driver.findElements(By.className("cart_item"));
        removedItemsFromCart=driver.findElements(By.className("removed_cart_item"));
        Assert.assertTrue(itemInCart.size()==1);
        Assert.assertTrue(removedItemsFromCart.size()==1);
    }

    @Test
    public void backToSchop(){
        checkIfNoAddedItems();
        continueShoppingButton=driver.findElement(By.id("continue-shopping"));
        continueShoppingButton.click();
        logo=driver.findElement(By.className("peek"));
        Assert.assertTrue(logo.isDisplayed());
    }
}
