package moduls;

import servises.FirstInterface;
import servises.SecondInterface;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

public class Injector {

    public <T> T inject(T object) {
        File file = new File("src/main/resources/data.properties");
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(AutoInjectable.class) && field.getType() == FirstInterface.class) {
                try {
                    Object someObject = null;
                    Class<?> clazz = null;
                    clazz = Class.forName(properties.getProperty("FirstInterface"));
                    someObject = clazz.newInstance();
                    field.set(object, someObject);
                } catch (IllegalAccessException | ClassNotFoundException | InstantiationException e) {
                    throw new RuntimeException(e);
                }
            }
            if (field.isAnnotationPresent(AutoInjectable.class) && field.getType() == SecondInterface.class) {
                try {
                    Object someObject = null;
                    Class<?> clazz = null;
                    clazz = Class.forName(properties.getProperty("SecondInterface"));
                    someObject = clazz.newInstance();
                    field.set(object, someObject);
                } catch (IllegalAccessException | ClassNotFoundException | InstantiationException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return object;
    }

}
