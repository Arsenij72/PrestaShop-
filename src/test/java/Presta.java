import org.openqa.selenium.By;
import org.junit.jupiter.api.Test;
import java.awt.datatransfer.StringSelection;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Presta extends BaseTest {

    @Test
    void ContactUsPass() {

        driver.findElement(By.id("contact-link")).click();

        Select dropdown = new Select(driver.findElement(By.id("id_contact")));
        dropdown.selectByVisibleText("Webmaster");


        driver.findElement(By.id("email")).sendKeys("email@gmail.com");

        WebElement fileInput = driver.findElement(By.className("buttonText"));
        String filename = "C:\\Users\\D3PT\\Downloads\\FileExample.txt";


        driver.findElement(By.id("contactform-message")).sendKeys("Hello");

        driver.findElement(By.cssSelector(".btn-primary")).click();

        WebElement confirmation = driver.findElement(By.cssSelector("form[method='post'] li"));
        String confirmMessage = confirmation.getText();
        assertEquals("Your message has been successfully sent to our team.", confirmMessage);


    }

    @Test
    void ContactUsFail() {

        driver.findElement(By.id("contact-link")).click();

        Select dropdown = new Select(driver.findElement(By.id("id_contact")));
        dropdown.selectByVisibleText("Webmaster");

        driver.findElement(By.id("email")).sendKeys("email@gmail.com");

        driver.findElement(By.className("buttonText")).click();
        String filename = "C:\\Users\\D3PT\\Downloads\\FileExample.txt";
        StringSelection filedetails = new StringSelection(filename);


        driver.findElement(By.id("contactform-message")).sendKeys("");

      driver.findElement(By.cssSelector(".btn-primary")).click();

        WebElement emptyfield = driver.findElement(By.cssSelector("form[method='post'] li"));
        String blankMessage = emptyfield.getText();
        assertEquals("The message cannot be blank.", blankMessage);
    }

}