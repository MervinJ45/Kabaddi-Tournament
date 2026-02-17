package study.reflections;

import study.annotations.AgeRange;
import study.annotations.RunMe;

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
    }
}
