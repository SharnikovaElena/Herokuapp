import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class CheckboxesTest extends BaseTest {

    @Test
    public void checkboxes() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkbox = driver.findElements(By.cssSelector("[type=checkbox]"));
        Assert.assertEquals(checkbox.size(), 2);
        Assert.assertFalse(checkbox.get(0).isSelected());
        checkbox.get(0).click();
        Assert.assertTrue(checkbox.get(0).isSelected());
        Assert.assertTrue(checkbox.get(1).isSelected());
        checkbox.get(1).click();
        Assert.assertFalse(checkbox.get(1).isSelected());
    }
}
