package utility;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

public class GenericMethods extends DriverFactory {
    public static String getScreenshot(String name) throws IOException {
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        String target = System.getProperty("user.dir") + "/target1/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        FileUtils.copyFile(source, finalDestination);
        return target;
    }

    public static void switchToWindow(String targetTitle) {
        String origin = getDriver().getWindowHandle();
        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
            if (getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        getDriver().switchTo().window(origin);
    }

    public static void mouseHover(WebElement element) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).perform();
    }

    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }

    public static List<String> getElementsText(By locator) {

        List<WebElement> elems = getDriver().findElements(locator);
        List<String> elemTexts = new ArrayList<>();

        for (WebElement el : elems) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }

    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static WebElement waitForElementVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibility(By locator, int timeout) {
        //WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
public static WebElement locateElemet(By locator){
       WebElement element= getDriver().findElement(locator);
       return  element;
}
    public  WebElement locateElemeT(By locator){
        WebElement element= getDriver().findElement(locator);
        return  element;
    }
    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForElementTobevisible(WebElement element, int timeInSeconds) {
        int maxAttempts = 5;
        int minattempts = 0;
        boolean visibility = false;
        try {
            for (int i = minattempts; i <= maxAttempts; i++) {
                Wait wait = new FluentWait(getDriver())
                        .withTimeout(Duration.ofSeconds(timeInSeconds))
                        .pollingEvery(Duration.ofSeconds(timeInSeconds))
                        .ignoring(Exception.class);
                wait.until(ExpectedConditions.visibilityOf(element));
                visibility = true;
                if (visibility) {
                    System.out.println(element + " is visible");
                    break;
                } else {
                    System.out.println(element + " is not visible after trying with 60 seconds ");
                }
            }
        } catch (NoSuchElementException e) {
            System.err.println(e);
        }
    }

    public static void waitForElementTobeClick(WebElement element) {
        int maxAttempts = 5;
        int minattempts = 0;
        boolean visibility = false;
        try {
            for (int i = minattempts; i <= maxAttempts; i++) {
                FluentWait wait = new FluentWait(getDriver())
                        .withTimeout(Duration.ofSeconds(60))
                        .pollingEvery(Duration.ofSeconds(10))
                        .ignoring(TimeoutException.class);
                wait.until(ExpectedConditions.visibilityOf(element));
                visibility = true;
                if (visibility) {
                    System.out.println(element + " is visible");
                    click(element);
                    break;
                } else {
                    System.out.println(element + " is not visible after trying with 60 seconds ");
                }
            }
        } catch (NoSuchElementException e) {
            System.err.println(e);
        }
    }

    public static void waitForElementTobeEnterText(WebElement element, String text) {
        int maxAttempts = 5;
        int minattempts = 0;
        boolean visibility = false;
        try {
            for (int i = minattempts; i <= maxAttempts; i++) {
                FluentWait wait = new FluentWait(getDriver())
                        .withTimeout(Duration.ofSeconds(60))
                        .pollingEvery(Duration.ofSeconds(10))
                        .ignoring(TimeoutException.class);
                wait.until(ExpectedConditions.visibilityOf(element));
                visibility = true;
                if (visibility) {
                    System.out.println(element + " is visible");
                    enterText(element, text);
                    break;
                } else {
                    System.out.println(element + " is not visible after trying with 60 seconds ");
                }
            }
        } catch (NoSuchElementException e) {
            System.err.println(e);
        }
    }

    public static void clickWithJS(WebElement element) {
        scrollToElement(element);
        highlight(element);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
    }

    public static void click(WebElement element) {
        scrollToElement(element);
        highlight(element);
        element.click();
    }

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void doubleClick(WebElement element) {
        new Actions(getDriver()).doubleClick(element).build().perform();
    }

    /**
     * Changes the HTML attribute of a Web Element to the given value using JavaScript
     *
     * @param element
     * @param attributeName
     * @param attributeValue
     */
    public static void setAttribute(WebElement element, String attributeName, String attributeValue) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", element, attributeName, attributeValue);
    }

    public static void highlight(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }

    public static void assrtHighlight(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].setAttribute('style', 'background: red; border: 2px solid red;');", element);
    }

    public static void selectCheckBox(WebElement element) {
        if (!element.isSelected()) {
            element.click();
        } else {
            System.out.println(element + " is already selected");
        }
    }

    public static void unSelectCheckBox(WebElement element) {
        if (element.isSelected()) {
            element.click();
        } else {
            System.out.println(element + " is already Unselected");
        }
    }

    public static void executeJSCommand(WebElement element, String command) {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript(command, element);

    }

    public static void enterText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public static void asertEquals(WebElement element, String actual, String Expected) {
        try {
            if (!actual.isEmpty() && !Expected.isEmpty()) {
                assrtHighlight(element);
                Assert.assertEquals(actual, Expected);
                System.out.println("Given "+actual+ "and "+Expected+ "both are same");
            }else {

            }
        }catch (Exception e){

        }
    }

    }
