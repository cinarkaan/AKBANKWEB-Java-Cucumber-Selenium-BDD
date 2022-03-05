package Base;

import Util.Base;
import Util.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EdgeBase extends Base implements DriverManager {

    public EdgeBase() {
        super("webdriver.edge.driver","C:\\Users\\kaan-\\Documents\\EdgeDriver\\msedgedriver.exe");
        initializeDriver();
    }

    @Override
    public void initializeDriver() {
        webDriver = new EdgeDriver();
        webDriver.manage().window().maximize();
        webDriverWait = new WebDriverWait(webDriver, 10);
        javascriptExecutor = (JavascriptExecutor) webDriver;
    }
}
