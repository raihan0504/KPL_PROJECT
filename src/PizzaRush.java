import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class PizzaRush {
    public static void main(String[] args) throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();

        File appDir = new File("src");
        File app = new File(appDir, "PizzaRush.apk");

        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "99151FFBA000T1");
        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        cap.setCapability("allowTestPackages", true); // Untuk menghindari INSTALL_FAILED_TEST_ONLY

        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(
            new URL("http://127.0.0.1:4723/"),
            cap
        );

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            // Klik tombol GET STARTED
            driver.findElementById("com.example.pizzaapp:id/buttonNext").click();

            // Klik teks REGISTER
            driver.findElementById("com.example.pizzaapp:id/textViewRegister").click();

            // Isi Email
            driver.findElementById("com.example.pizzaapp:id/registerEmail").sendKeys("aderiski@gmail.com");

            // Isi Nama
            driver.findElementById("com.example.pizzaapp:id/registerPersonName").sendKeys("ade");

            // Isi Level
            driver.findElementById("com.example.pizzaapp:id/registerLevel").sendKeys("2");

            // Isi Password
            driver.findElementById("com.example.pizzaapp:id/registerPassword").sendKeys("12");
            
         // Tekan tombol Save/Register
            driver.findElementById("com.example.pizzaapp:id/buttonRegisterAccount").click();
            System.out.println("Akun berhasil didaftarkan (tombol Save diklik).");

            System.out.println("Form registrasi berhasil diisi.");
            
         // Isi Email pada halaman login
            driver.findElementById("com.example.pizzaapp:id/editTextEmail").sendKeys("aderiski@gmail.com");

            // Isi Password
            driver.findElementById("com.example.pizzaapp:id/editTextPassword").sendKeys("12");

            // Tekan tombol Login
            driver.findElementById("com.example.pizzaapp:id/buttonLogin").click();
            System.out.println("Login berhasil diklik.");
            
            // Tekan tombol Menu
            driver.findElementById("com.example.pizzaapp:id/fragmentMakanan").click();
            
            // Tekan tombol add menu
            driver.findElementById("com.example.pizzaapp:id/buttonAddMenu").click();
            
            // Isi id
            driver.findElementById("com.example.pizzaapp:id/menuId").sendKeys("1");
            
            // Isi Nama
            driver.findElementById("com.example.pizzaapp:id/menuName").sendKeys("Pizza paparon");
            
            // Isi Harga
            driver.findElementById("com.example.pizzaapp:id/menuPrice").sendKeys("30000");
            
            // Isi gambar
            driver.findElementById("com.example.pizzaapp:id/buttonAddImage").click();
            driver.findElementById("android:id/button_once").click();
            driver.findElementByXPath("(//android.widget.ImageView[@resource-id=\"com.google.android.apps.photosgo:id/image1\"])[2]").click();
            driver.findElementByXPath("//android.view.View[@content-desc=\"Photo taken on Jun 2, 2025 3:40:39 PM.\"]").click();
            
            // tekan tombol save
            driver.findElementById("com.example.pizzaapp:id/buttonSaveMenu").click();
            
            //tekan menu 
            driver.findElementById("com.example.pizzaapp:id/fragmentMakanan").click();
            
            //tekan tambah menu
            driver.findElementById("com.example.pizzaapp:id/buttonAddMenu").click();
            
            //Gambar kedua  
            // Isi id
            driver.findElementById("com.example.pizzaapp:id/menuId").sendKeys("2");
            
            // Isi Nama
            driver.findElementById("com.example.pizzaapp:id/menuName").sendKeys("Pizza Mozarela");
            
            // Isi Harga
            driver.findElementById("com.example.pizzaapp:id/menuPrice").sendKeys("100000");
            
            // Isi gambar
            driver.findElementById("com.example.pizzaapp:id/buttonAddImage").click();
            driver.findElementById("android:id/button_once").click();
            driver.findElementByXPath("(//android.widget.ImageView[@resource-id=\"com.google.android.apps.photosgo:id/image1\"])[2]").click();
            driver.findElementByXPath("//android.view.View[@content-desc=\"Photo taken on Jun 2, 2025 3:40:24 PM.\"]").click();
            driver.findElementById("com.example.pizzaapp:id/buttonSaveMenu").click();
            
            // tambah ke payment
            driver.findElementByXPath("(//android.widget.Button[@resource-id=\"com.example.pizzaapp:id/buttonTambah\"])[1]").click();
            
            // Menu payment
            driver.findElementById("com.example.pizzaapp:id/fragmentTransaction").click();
            
            // tambah pizza
            driver.findElementById("com.example.pizzaapp:id/imageButtonPlus").click();
            
            // tekan tombol Pay now
            driver.findElementById("com.example.pizzaapp:id/buttonPayNow").click();
            
            // cash
            driver.findElementById("com.example.pizzaapp:id/editTextCash").sendKeys("66000");
            driver.findElementById("com.example.pizzaapp:id/buttonFinish").click();
        } catch (Exception e) {
            System.out.println("Terjadi error: " + e.getMessage());
        } finally {
           // driver.quit(); // Tutup sesi setelah selesai
        }
    }
}
