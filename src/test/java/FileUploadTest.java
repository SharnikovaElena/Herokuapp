import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class FileUploadTest extends BaseTest {
    @Test
    public void fileUpload(){
        driver.get("http://the-internet.herokuapp.com/upload");
        File file = new File("src/test/resources/Аккаунт менеджер.png");
        driver.findElement(By.id("file-upload")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.id("file-submit")).click();

        Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText(), "Аккаунт менеджер.png", "File not found");
    }
}
