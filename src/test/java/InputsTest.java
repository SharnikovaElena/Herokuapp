import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InputsTest extends BaseTest {
    @Test
    public void inputs() {
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement numberInput = driver.findElement(By.tagName("input"));
        numberInput.sendKeys("14");
        numberInput.sendKeys(Keys.ARROW_DOWN);
        String actualText1 = numberInput.getAttribute("value");
        Assert.assertEquals(actualText1, "13", "This bug is related to the Keys.ARROW_DOWN method");
        numberInput.sendKeys(Keys.ARROW_UP);
        String actualText2 = numberInput.getAttribute("value");
        Assert.assertEquals(actualText2, "14", "This bug is related to the Keys.ARROW_UP method");
    }

    @Test
    public void inputSymbolsInvalid() {
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement symbolsInput = driver.findElement(By.tagName("input"));
        symbolsInput.sendKeys("%_$");
        String actualResult = symbolsInput.getAttribute("value");
        Assert.assertEquals(actualResult, "", "Input does not accept non-digital values");
    }

    @Test
    public void inputLettersInvalid() {
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement lettersInput = driver.findElement(By.tagName("input"));
        lettersInput.sendKeys("poi");
        String actualResult = lettersInput.getAttribute("value");
        Assert.assertEquals(actualResult, "", "Input does not accept non-digital values");
    }
}
