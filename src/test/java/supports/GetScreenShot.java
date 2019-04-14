package supports;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GetScreenShot {

    public static String capture(WebDriver driver, String screenShotName) throws IOException {

        String dateFormat = new SimpleDateFormat("ddMMyyyy_hhmmss").format(Calendar.getInstance().getTime());
        TakesScreenshot ts = (TakesScreenshot) driver;
        String strBase64 = ts.getScreenshotAs(OutputType.BASE64);
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") + "/src/test/java/reports/images/" + screenShotName + "_" + dateFormat + ".png";
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);
//        return dest; //Using when it isn't local resource
        return strBase64;
    }
}