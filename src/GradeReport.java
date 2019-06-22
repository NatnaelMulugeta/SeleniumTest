import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.FileWriter;

//done by: Natnael Mulugeta  -- ATR/4355/09

public class GradeReport {
    public static void main(String[] args){
        String id= "username";
        String password ="password";
        System.setProperty("webdriver.chrome.driver", "/home/natnaelmulugeta/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");

        WebDriver driver = new ChromeDriver(options);
        String appUrl = "http://portal.aait.edu.et";
        driver.get(appUrl);

        driver.findElement(By.xpath("//*[@id=\"UserName\"]")).sendKeys(id);
        driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"home\"]/div[2]/div[2]/form/div[4]/div/button\n")).submit();
        driver.get("https://portal.aait.edu.et/Grade/GradeReport\n");

        String grade = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div")).getText();

        try{
            FileWriter fw=new FileWriter("gradeReport.txt");
            fw.write(grade);
            fw.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
