import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.setProperty("webdriver.chrome.driver", "resources/chrome.exe");
        driver.get("https://terenuri.dev.evozon.com/");

        driver.findElement(By.cssSelector("[href='/login']")).click();
        wait(2);
        driver.findElement(By.cssSelector("[name='email']")).sendKeys("testdemo@yahoo.com");
        driver.findElement(By.cssSelector("[name='password']")).sendKeys("Q@Test1234");
        driver.findElement(By.cssSelector("[type='submit']")).click();
        wait(4);

        driver.findElement(By.linkText("REZERVARI")).click();
        String URL = driver.getCurrentUrl();
        Assert.isTrue(true, URL, "https://terenuri.dev.evozon.com/reservations");
        wait(2);

        driver.findElement(By.cssSelector("[src*='/_next/image?url=%2Fimages%2Ffotbal.png&w=3840&q=75']")).click();
        wait(2);

        driver.findElement(By.cssSelector("#mui-component-select-sportsComplexSlug")).click();
        driver.findElement(By.cssSelector("[data-value='gheorgheni-base']")).click();
        wait(4);
        driver.findElement(By.cssSelector("#mui-component-select-courtId")).click();
        driver.findElement(By.xpath("//li[text()='Fotbal 3']")).click();
        wait(4);

//        String limitarezervare = driver.findElement(By.xpath("//p[text()='Ai atins limita de rezervări admise pentru Fotbal în această săptămână.']")).getText();
//        Assert.isTrue(true, limitarezervare, "Ai atins limita de rezervări admise pentru Fotbal în această săptămână.");
//        while (limitarezervare = true) wait(2);

        driver.findElement(By.cssSelector("[data-testid='ArrowForwardIcon']")).click();
        wait(2);
//        driver.findElement(By.cssSelector("[data-testid='ArrowForwardIcon']")).click();
//        Thread.sleep(2000);
        driver.findElement(By.xpath("//h6[text()='20']")).click();
        wait(2);
        driver.findElement(By.xpath("//span[text()='14:00']")).click();
        wait(2);
        driver.findElement(By.cssSelector("[type='submit']")).click();
        wait(2);

        driver.findElement(By.xpath("//span[text()='Voi invita încă 3 persoane care își vor confirma prezența în termen de 2 ore. În caz contrar, rezervarea va fi anulată.']")).click();
        wait(2);
        driver.findElement(By.xpath("//span[text()='Am citit regulamentul specific*']")).click();
        wait(2);
        driver.findElement(By.xpath("//span[text()='Sunt de acord cu Regulamentul de funcționare*']")).click();
        wait(2);
        driver.findElement(By.xpath("//button[text()='Confirmă rezervarea']")).click();
        wait(4);

        String confirmare = driver.findElement(By.xpath("//p[text()='Rezervare confirmată']")).getText();
        Assert.isTrue(true, confirmare, "Rezervare confirmată");
        wait(2);

        driver.findElement(By.cssSelector("[class='MuiButtonBase-root  MuiIconButton-root MuiIconButton-sizeMedium  mui-ji010s']")).click();
        wait(4);
        driver.findElement(By.xpath("//p[text()='Rezervările mele']")).click();
        wait(4);
        driver.findElement(By.xpath("//p[text()='Anulează rezervarea']")).click();
        wait(4);
        driver.findElement(By.xpath("//button[text()='Salvează']")).click();
        wait(4);

        driver.quit();

    }

    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}