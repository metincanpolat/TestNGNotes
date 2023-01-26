package Gun05;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _01_DataProvider {

    @Test(dataProvider = "getData") // benim data sağlayıcım getData fonksiyonudur.
    void SearchTest(String searchText){

        System.out.println(searchText);
    }

    @DataProvider // bu metoda DataProvider görevi verildi
    Object[] getData(){ // DataProvider olarak kullanılacak metodun tipi object olmak zorunda

        Object[] data={"Mac","Samsung","Huawei","iphome","pc","Xaomi"};

        return data;
    }

    /**************************************/

    @Test(dataProvider = "aranacaklar") // benim data sağlayıcım getData fonksiyonudur.
    void SearchTest2(String searchText){

        System.out.println(searchText);

    }
    @DataProvider (name = "aranacaklar") //
    Object[] getData2(){

        Object[] data={"Mac","Samsung","Huawei","iphome","pc","Xaomi"}; // int sayı değeri de verilebilir

        return data;
    }
}
