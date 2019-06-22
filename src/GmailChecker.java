package autotest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.PrintWriter;
import java.util.List;

//done by: Natnael Mulugeta  -- ATR/4355/09

public class GmailChecker {

    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver" , "/home/natnaelmulugeta/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");

        WebDriver driver = new ChromeDriver(options);
        String appUrl = "http://mail.google.com";
        driver.get(appUrl);


        WebElement emailInput = driver.findElement(By.id("identifierId"));
        WebElement emailNextButton = driver.findElement(By.id("identifierNext"));
        emailInput.sendKeys("email");
        emailNextButton.click();

        Thread.sleep(1000);
        WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));
        WebElement passwordNextutton = driver.findElement(By.id("passwordNext"));
        passwordInput.sendKeys("password");
        passwordNextutton.click();

        Thread.sleep(2000);

        List<WebElement> unreadEmails = driver.findElements(By.xpath("//*[@class='zA zE']"));

        System.out.println(unreadEmails.size());
        PrintWriter writer = new PrintWriter("emails.txt", "UTF-8");
        for(int i = 0; i < unreadEmails.size(); i++) {
            WebElement from = unreadEmails.get(i).findElement(By.xpath(".//*[@class='yW']"));
            writer.println("From : " + from.getText());

            WebElement subject = unreadEmails.get(i).findElement(By.xpath(".//*[@class='bog']"));
            writer.println("Subject : " + subject.getText());

        }
        //writer.println("end");
        writer.close();

    }
}
