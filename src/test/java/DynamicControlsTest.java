import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;

public class DynamicControlsTest extends BaseTest {
    @Test
    public void dynamicControls() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//form[@id='checkbox-example']/button[@autocomplete='off']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        assertEquals(driver.findElement(By.xpath("//form[@id='checkbox-example']/p[@id='message']")).getText(), "It's gone!", "The text does not meet the requirements");

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        int numberOfElements = driver.findElements(By.xpath("//form/div[@id='checkbox']")).size();
        assertEquals(numberOfElements, 0, "The element is present on the page");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //        не срабатывает Assert
        assertEquals(driver.findElement(By.xpath("//form/input[@type='text']")).isEnabled(), "false", "Input enabled");

        driver.findElement(By.xpath("//form[@id='input-example']/button[@autocomplete='off']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        assertEquals(driver.findElement(By.xpath("//form[@id='input-example']/p[@id='message']")).getText(), "It's enabled!", "The text does not meet the requirements");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //        не срабатывает Assert
        assertEquals(driver.findElement(By.xpath("//form/input[@type='text']")).isEnabled(), "true", "Input disabled");

    }
}
