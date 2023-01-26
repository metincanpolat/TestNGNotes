package Gun01;

import Utils.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _05_Assetions {

    @Test
    void EqualOrnek(){

        String s1="Merhaba";
        String s2="Merhaba1";
                        //Actual(oluşan),Expected(beklenen),Mesaj(opsiyonel)
        Assert.assertEquals(s1,s2,"Karşılaştırma sonucu"); // hard assertion, soft assertion ile  toplu göreceğiz ilerde
        //Actual - Expected - Message ( A E M) sırasını alfabetik sıraya göre hatırlayabiliriz

    }
    @Test
    void NotEqualOrnek(){
        String s1="Merhaba";
        String s2="Merhaba1";
        Assert.assertNotEquals(s1,s2,"Değerler eşit");

    }
    @Test
    void TrueOrnek(){
        int s1=55;
        int s2=66;

        Assert.assertTrue(s1==s2,"Değerler eşit değil");
    }
    @Test
    void nullOrnek(){
        String s1="ismet"; //null

        Assert.assertNull(s1,"değer null değil");
    }
    @Test
    void direktFail(){
        int a=55;

        if (a==55)
            Assert.fail();
    }

}
