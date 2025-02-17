
import org.openqa.selenium.By;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Presta2 extends BaseTest {

    // @ParameterizedTest
    // @CsvFileSource(files = "src/main/resources/products.csv")
    //void Csvfile(String Product, Integer Price, Integer Discount, String Size) {
    //  assertEquals(Product, Price, Discount, Size);
//}

    @Test
    void SearchProductFirst() {

        driver.findElement(By.className("ui-autocomplete-input")).sendKeys("Hummingbird printed t-shirt");
        //  assertEquals("Hummingbird printed t-shirt", driver.findElement(By.className("ui-autocomplete-input")).getText());

       WebElement searchitem = driver.findElement(By.cssSelector(".ui-corner-all > .product"));
        String extractedSearch = searchitem.getText();
        assertEquals("Hummingbird printed t-shirt", extractedSearch);

        driver.findElement(By.id("ui-id-1")).click();
        driver.findElement(By.cssSelector(".wishlist-button-product .material-icons")).click();

        WebElement wishlist = driver.findElement(By.cssSelector(".modal-text"));
        String extractedText = wishlist.getText();
        assertEquals("You need to be logged in to save products in your wishlist.", extractedText);

        driver.findElement(By.cssSelector(".wishlist-login > div[role='dialog'] > div[role='document'] .btn.btn-secondary.modal-cancel")).click();

        Select dropdown = new Select(driver.findElement(By.id("group_1")));
        dropdown.selectByVisibleText("XL");

        driver.findElement(By.cssSelector(".add-to-cart.btn.btn-primary")).click();

        //WebElement carterror = driver.findElement(By.cssSelector("h4#myModalLabel"));
//String addtocartText = carterror.getText();
        // assertEquals("Product successfully added to your shopping cart", addtocartText);


        driver.findElement(By.cssSelector(".modal-body .btn.btn-primary")).click();


            WebElement itemname = driver.findElement(By.cssSelector("[data-id_customization]"));
            String extractedItem = itemname.getText();
            assertEquals("Hummingbird printed t-shirt", extractedItem);

            WebElement itemsize = driver.findElement(By.cssSelector(".product-line-info.size > .value"));
            String extractedSize = itemsize.getText();
            assertEquals("XL", extractedSize);

            WebElement itemdiscount = driver.findElement(By.cssSelector(".discount.discount-percentage"));
            String extractedDiscount = itemdiscount.getText();
            assertEquals("-20%", extractedDiscount);


        }


@Test
void SearchProductSecond() {
    driver.findElement(By.className("ui-autocomplete-input")).sendKeys("HUMMINGBIRD PRINTED SWEATER");

    WebElement searchitem2 = driver.findElement(By.cssSelector(".ui-corner-all > .product"));
    String extractedSearch2 = searchitem2.getText();
   assertEquals("Hummingbird printed sweater", extractedSearch2);

    driver.findElement(By.id("ui-id-1")).click();
    driver.findElement(By.cssSelector(".wishlist-button-product .material-icons")).click();

    WebElement wishlist = driver.findElement(By.cssSelector(".modal-text"));
    String extractedText = wishlist.getText();
    assertEquals("You need to be logged in to save products in your wishlist.", extractedText);

    driver.findElement(By.cssSelector(".wishlist-login > div[role='dialog'] > div[role='document'] .btn.btn-secondary.modal-cancel")).click();

    Select dropdown = new Select(driver.findElement(By.id("group_1")));
    dropdown.selectByVisibleText("M");

    driver.findElement(By.cssSelector(".add-to-cart.btn.btn-primary")).click();
    driver.findElement(By.cssSelector(".modal-body .btn.btn-primary")).click();

    WebElement itemname = driver.findElement(By.cssSelector("[data-id_customization]"));
    String extractedItem = itemname.getText();
    assertEquals("Hummingbird printed sweater", extractedItem);

    WebElement itemsize = driver.findElement(By.cssSelector(".product-line-info.size > .value"));
    String extractedSize = itemsize.getText();
    assertEquals("M", extractedSize);

    WebElement itemdiscount = driver.findElement(By.cssSelector(".discount.discount-percentage"));
    String extractedDiscount = itemdiscount.getText();
    assertEquals("-20%", extractedDiscount);

}
}

