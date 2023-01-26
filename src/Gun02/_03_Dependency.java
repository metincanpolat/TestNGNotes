package Gun02;

import Utils.BaseDriver;
import org.testng.annotations.Test;

public class _03_Dependency extends BaseDriver {

    @Test
    void startCar(){
        System.out.println("Start Car");
    }

    @Test(dependsOnMethods = {"startCar"}) // bu testin çalışması, startCar ın hatasız çalışmasına bağlı.
    void driveCar(){
        System.out.println("Drive Car");
    }

    @Test(dependsOnMethods = {"startCar","driveCar"}) // istersen 2 koşul verebiliyoruz.
    void parkCar(){
        System.out.println("Park Car");
    }

    @Test(dependsOnMethods = {"parkCar"},alwaysRun = true)
    void stopCar(){
        System.out.println("Stop Car");
    }
    // aynı seviyedeki testleri için priority verilebilir.
    // bağımlı testler, direk metodundan çalıştırdığınızda bağımlı olduğu metod zincirinde 2 üste kadar otomatik çağırıp çalışabilir.
}
