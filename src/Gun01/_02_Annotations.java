package Gun01;

import org.testng.annotations.*;

public class _02_Annotations {

    @BeforeClass
    void beforeClass(){
        System.out.println("Her class dan ÖNCE çalışacak"); // driver ve diğer test öncesi bütün işlemler.
    }

    @BeforeMethod
    void beforeMethod(){
        System.out.println("Her method dan ÖNCE çalışacak");
    }

    @AfterMethod
    void afterMethod(){
        System.out.println("Her method dan sonra çalışacak");
    }

    @AfterClass
    void afterClass(){
        System.out.println("Her class dan SONRA çalışacak"); //driver kapat vs..
    }

    @Test
    void test1(){
        System.out.println("test1 çalıştı");
    }

    @Test
    void test2(){
        System.out.println("test2 çalıştı");
    }
}
