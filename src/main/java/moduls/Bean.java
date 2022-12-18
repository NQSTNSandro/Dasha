package moduls;

import servises.FirstInterface;
import servises.SecondInterface;

public class Bean {
    @AutoInjectable
    public FirstInterface firstInterface;

    @AutoInjectable
    public SecondInterface secondInterface;

    public void foo(){
        firstInterface.printInfo();
        secondInterface.printInfo();
    }
}
