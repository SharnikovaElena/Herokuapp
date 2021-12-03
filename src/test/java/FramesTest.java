import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesTest extends  BaseTest {

    @Test
    public  void iFrame(){
        driver.get("http://the-internet.herokuapp.com/frames");
        driver.findElement(By.xpath("//a[@href='/iframe']")).click();
        WebDriver frame = driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));

        Assert.assertEquals(frame.findElement(By.xpath("//body[@id='tinymce']/p")).getText(), "Your content goes here.", "The text within the paragraph is incorrect");
    }
}
