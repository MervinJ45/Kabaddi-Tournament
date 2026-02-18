package study.reflections;

import study.annotations.AgeRange;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.annotation.Annotation;

public class Reflections {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //getting the class of the Player
        Class<?> playerClass = Player.class;
        //getting the constructor of that class
        //may throw NoSuchMethodException if wrong parameter given
        Constructor<?> playerConst = playerClass.getDeclaredConstructor(String.class, int.class);
        //creating an object with constructor taken using reflection
        Object player = playerConst.newInstance("Rohit", 38);
        //creating new instances with non parameterized constructor
        Constructor<?> defaultPlayerConst = playerClass.getDeclaredConstructor();
        Object dhoni = defaultPlayerConst.newInstance();
        Object rahul = defaultPlayerConst.newInstance();
        //retrieving all the methods from a class using reflection
        Method[] methods = playerClass.getDeclaredMethods();
        for (Method method : methods) {
            //method invoked using reflection
            if (method.getName().equals("methodToInvoke")) {
                //System.out.println(method.invoke(player));
            }
            //System.out.println(method);
            //getting parameters of a method
            Class<?>[] params = method.getParameterTypes();
            for (Class<?> param : params) {
                //System.out.println(param);
            }
            //getting all the method annotations of a class
            Annotation[] methodAnnotations = method.getAnnotations();
            for (Annotation annotation : methodAnnotations) {
                //System.out.println(annotation);
            }
        }
        //getting all the fields in a class
        Field[] fields = playerClass.getDeclaredFields();
        for (Field field : fields) {
            //made fields with private access modifier also assessable
            //or else IllegalAccessException thrown
            field.setAccessible(true);
            //getting names of a field
            //System.out.println(field.getName());
            //getting values of the field by passing obj
            //System.out.println(field.get(player));
            //getting all field annotations of a class
            Annotation[] fieldAnnotations = field.getAnnotations();
            for (Annotation annotation : fieldAnnotations) {
                //System.out.println(annotation);
            }
        }
        //takes only class level annotation
        Annotation[] annotations = playerClass.getAnnotations();
        for (Annotation annotation : annotations) {
            //System.out.println(annotation);
        }
        //setting field values of an object using reflection
        for (Field field : fields) {
            if (field.getName().equals("playerName")) {
                field.set(dhoni, "Dhoni");
            }
            if (field.getName().equals("playerAge")) {
                field.set(dhoni, 44);
            }
        }
        System.out.println(dhoni);

        //setting values to object using setters methods
        for (Method method : methods) {
            if (method.getName().equals("setPlayerName")) {
                method.invoke(rahul, "Rahul");
            }
            if (method.getName().equals("setPlayerAge")) {
                method.invoke(rahul, 33);
            }
        }
        System.out.println(rahul);
    }
}
