package Gun05;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _02_DataProvider_CokBoyutlu {



    @Test(dataProvider = "getData")
    void LoginTest(String userName, String password)
    {
        System.out.println("userName = "+userName+", password = "+password);
    }

    @DataProvider
    Object[][] getData(){

        Object[][] logins={
                {"Hasan","1225215"},
                {"Birkan","dsf34fs"},
                {"Metin","1dcd5d15"},
                {"Ufuk","122sfs215"}
        };
        return logins;
    }
}
