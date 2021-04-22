import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class StronaGlowna extends Base{

    Select whichSort;
    List<WebElement> inventoryItems;
    WebElement imageName;
    WebElement imageChild;
    static WebElement addToCart;
    WebElement itemInCart;
    WebElement removeFromoCart;

    @BeforeEach
    public void prep(){
        Logowanie.logInIn();
    }

    @Test
    public void checkItem(){
        whichSort=new Select(driver.findElement(By.className("product_sort_container")));
        whichSort.selectByValue("za");
        sortetCompate("item_3_img_link");
        whichSort=new Select(driver.findElement(By.className("product_sort_container")));
        whichSort.selectByValue("az");
        sortetCompate("item_4_img_link");
        whichSort=new Select(driver.findElement(By.className("product_sort_container")));
        whichSort.selectByValue("lohi");
        sortetCompate("item_2_img_link");
        whichSort=new Select(driver.findElement(By.className("product_sort_container")));
        whichSort.selectByValue("hilo");
        sortetCompate("item_5_img_link");
    }

    @Test
    public void addItem(){
        addAdd();
        itemInCart= driver.findElement(By.className("shopping_cart_link"));
        Assert.assertTrue(itemInCart.isDisplayed());
    }

    @Test
    public void removeItem(){
        addItem();
        removeFromoCart=driver.findElement(By.id("remove-sauce-labs-backpack"));
        removeFromoCart.click();
        Assert.assertEquals("1",itemInCart.getText());
    }

    private void sortetCompate(String firstSortElement){
        inventoryItems=driver.findElements(By.className("inventory_item_img"));
        imageName=driver.findElement(By.id(firstSortElement));
        imageChild=inventoryItems.get(0).findElement(By.id(firstSortElement));
        Assert.assertEquals(imageChild,imageName);
    }

    public static void addAdd(){
        addToCart=driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        addToCart.click();
        addToCart=driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCart.click();
    }
}
