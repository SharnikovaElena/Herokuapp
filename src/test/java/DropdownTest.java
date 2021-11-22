import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class DropdownTest extends BaseTest {

    @Test
    public void dropdown() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        WebElement dropdownList = driver.findElement(By.id("dropdown"));
        dropdownList.click();
        List<WebElement> option = driver.findElements(By.tagName("option"));
        Assert.assertEquals(option.size(), 3, "Количество элементов не равно 3");
        option.get(1).click();
        Assert.assertTrue(option.get(1).isSelected());
        option.get(2).click();
        Assert.assertTrue(option.get(2).isSelected());
    }
}
