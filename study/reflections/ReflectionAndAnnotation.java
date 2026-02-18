package study.reflections;

import study.annotations.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionAndAnnotation {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> playerClass = Player.class;
        Constructor<?> playerConst = playerClass.getDeclaredConstructor(String.class, int.class);
        Object virat = playerConst.newInstance("Virat", 37);
        Field[] fields = playerClass.getDeclaredFields();

        //getting a default constructor using annotation
        Constructor<?> defaultConst = null;
        Constructor[] constructors = playerClass.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            if (constructor.isAnnotationPresent(DefaultConstructor.class)) {
                defaultConst = constructor;
            }
        }
        Object sky = defaultConst.newInstance();
        Object bumrah = defaultConst.newInstance();

        //validate age of a player using reflection and annotation
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(AgeRange.class)) {
                AgeRange ageRange = field.getAnnotation(AgeRange.class);
                int curAge = (int) field.get(virat);
                if (curAge < ageRange.min() || curAge > ageRange.max()) {
                    throw new RuntimeException(curAge + " is invalid age");
                }
            }
        }

        //invoking method with a specific annotation
        Method[] methods = playerClass.getDeclaredMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            if (method.isAnnotationPresent(RunMe.class)) {
                System.out.println(method.invoke(virat));
            }
        }

        //setting values of field using annotation
        for (Field field : fields) {
            if (field.isAnnotationPresent(Name.class)) {
                field.set(sky, "Surya Kumar Yadav");
            }
            if (field.isAnnotationPresent(Age.class)) {
                field.set(sky, 35);
            }
        }
        System.out.println(sky);

        //invoking methods with annotation
        for (Method method : methods) {
            if (method.isAnnotationPresent(SetNameMethod.class)) {
                method.invoke(bumrah, "Jasprit Bumrah");
            }
            if (method.isAnnotationPresent(SetAgeMethod.class)) {
                method.invoke(bumrah, 32);
            }
        }
        System.out.println(bumrah);
    }
}
