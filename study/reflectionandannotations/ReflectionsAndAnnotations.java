package study.reflectionandannotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionsAndAnnotations {
    public static void main(String[] args) throws ClassNotFoundException {

        Class<?> playerClass = Class.forName("objtoobjconversion.Student");
        System.out.println("Class level Annotations");
        Annotation[] classAnnotations = playerClass.getDeclaredAnnotations();
        if (classAnnotations.length == 0) {
            System.out.println(playerClass.getName() + " : No Annotations Found");
        } else {
            for (Annotation annotation : classAnnotations) {
                System.out.println(playerClass.getName() + " " + annotation);
            }
        }
        System.out.println("Field level Annotations");
        Field[] fields = playerClass.getDeclaredFields();
        for (Field field : fields) {
            Annotation[] fieldAnnotations = field.getDeclaredAnnotations();
            if (fieldAnnotations.length == 0) {
                System.out.println(field.getName() + " : No Annotations Found");
            } else {
                for (Annotation annotation : fieldAnnotations) {
                    System.out.println(field.getName() + " : " + annotation);
                }
            }
        }
        System.out.println("Method level Annotations");
        Method[] methods = playerClass.getDeclaredMethods();
        for (Method method : methods) {
            Annotation[] methodAnnotations = method.getDeclaredAnnotations();
            if (methodAnnotations.length == 0) {
                System.out.println(method.getName() + " : No Annotations Found");
            } else {
                for (Annotation annotation : methodAnnotations) {
                    System.out.println(method.getName() + " " + annotation);
                }
            }
        }
    }
}
