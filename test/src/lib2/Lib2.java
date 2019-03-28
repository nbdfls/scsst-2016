package lib2;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class Lib2 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private static final String EXCEL_FILE_LOCATION = "/Users/lishuifan/Documents/Java/test/软件测试名单.xls";
  WebElement usernameEle,passwordEle;

  @Before
  public void setUp() throws Exception {
    String driverPath = System.getProperty("user.dir") + "/src/resources/geckodriver";
    System.setProperty("webdriver.gecko.driver", driverPath);
    driver = new FirefoxDriver();
    baseUrl = "http://121.193.130.195:8800/login";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }


  @Test
  public void testLib2() throws Exception {
    String nameTest,idTest,gitTest;

    Workbook wb = Workbook.getWorkbook(new File(EXCEL_FILE_LOCATION));
    Sheet rs = wb.getSheet(0);
    //开始分批次读取数据
    for(int i = 1;i<rs.getRows();i++)
    {
      Cell cellId = rs.getCell(1,i);
      String id = cellId.getContents();
      String pwd = id.substring(4);

      Cell cellName = rs.getCell(2,i);
      String name = cellName.getContents();

      Cell cellGit = rs.getCell(3,i);
      String git = cellGit.getContents();
      driver.get("http://121.193.130.195:8800/login");

      usernameEle = driver.findElement(By.name("id"));
      passwordEle = driver.findElement(By.name("password"));
      usernameEle.click();
      usernameEle.clear();
      usernameEle.sendKeys(id);
      passwordEle.clear();
      passwordEle.sendKeys(pwd);
      driver.findElement(By.id("btn_login")).click();

//      赋值并进行检查
      nameTest = driver.findElement(By.id("student-name")).getText();
      idTest = driver.findElement(By.id("student-id")).getText();
      gitTest = driver.findElement(By.id("student-git")).getText();

      assertEquals(name,nameTest);
      assertEquals(id,idTest);
      assertEquals(git,gitTest);

      driver.findElement(By.id("btn_logout")).click();
      driver.findElement(By.id("btn_return")).click();
    }
    wb.close();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
