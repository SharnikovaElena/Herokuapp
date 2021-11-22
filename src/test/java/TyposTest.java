import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TyposTest extends BaseTest {
    @Test
    public void typos() {
        driver.get("http://the-internet.herokuapp.com/typos");
        WebElement textElement = driver.findElement(By.xpath("//div[@class='example']/p[2]"));
        String actualText = textElement.getText();
        Assert.assertEquals(actualText, "Sometimes you'll see a typo, other times you won't.", "Spelling error detected");
    }
}
