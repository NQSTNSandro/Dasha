package moduls;

import servises.FirstInterface;
import servises.SecondInterface;

/**
 * Класс Bean для теста
 */
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
