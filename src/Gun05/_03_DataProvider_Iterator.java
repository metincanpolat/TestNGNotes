package Gun05;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class _03_DataProvider_Iterator {

    @Test(dataProvider = "getData")
    void SearchTest(String searchText){

        System.out.println("searchText = "+searchText);
    }

    @DataProvider
    Iterator<Object> getData(){

        List<Object> data=new ArrayList<>(Arrays.asList("Mac","Samsung","Huawei","iphome","pc","Xaomi"));

        return data.iterator();
    }

    /*************************************/

    @Test(dataProvider = "getData2")
    void LoginTest(String userName, String password)
    {
        System.out.println("userName = "+userName+", password = "+password);
    }

    @DataProvider
    Iterator<Object[]> getData2(){

        List<Object[]> logins=new ArrayList<>();
        logins.add(new Object[]{"Hasan","1225215"});
        logins.add(new Object[]{"Birkan","dsf34fs"});
        logins.add(new Object[]{"Metin","1dcd5d15"});

        return logins.iterator();
    }






}
