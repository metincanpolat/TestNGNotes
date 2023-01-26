package Gun01;

import org.testng.annotations.Test;

public class _01_Giris {


    @Test(priority = 1) //// Eğer herhangi bir sıralama verilmezse metod isimlerinin alfabetik çalışıyor
    void webSitesiniAc(){
        System.out.println("Driver tanımlandı ve web sitesi açıldı");
    }

    @Test (priority = 2)
    void loginIsleminiYap(){
        System.out.println("Login test işlemleri yapıldı");
    }

    @Test (priority = 3)
    void driveriKapat(){
        System.out.println("driver kapatıldı ve çıkıldı");
    }
}
