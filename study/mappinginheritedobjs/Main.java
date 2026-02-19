package study.mappinginheritedobjs;

import study.annotations.FieldOf;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Employee employee = new Employee();
        Student student = new Student();
        convert(employee, student);
    }

    public static void convert(Object src, Object des) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> srcClass = src.getClass();
        ArrayList<Field> srcFieldList = new ArrayList<>();
        ArrayList<Method> srcMethodList = new ArrayList<>();
        while (srcClass != Object.class) {
            Field[] fields = srcClass.getDeclaredFields();
            for (Field field : fields) {
                srcFieldList.add(field);
            }
            Method[] methods = srcClass.getDeclaredMethods();
            for (Method method : methods) {
                srcMethodList.add(method);
            }
            srcClass = srcClass.getSuperclass();
        }

        Class<?> desClass = des.getClass();
        ArrayList<Field> desFieldList = new ArrayList<>();
        ArrayList<Method> desMethodList = new ArrayList<>();
        while (desClass != Object.class) {
            Field[] fields = desClass.getDeclaredFields();
            for (Field field : fields) {
                desFieldList.add(field);
            }
            Method[] methods = desClass.getDeclaredMethods();
            for (Method method : methods) {
                desMethodList.add(method);
            }
            desClass = desClass.getSuperclass();
        }

        for (Field srcField : srcFieldList) {
            for (Field desField : desFieldList) {
                if (checkAnnotation(srcField, desField)) {
                    if (Modifier.isPrivate(srcField.getModifiers()) || Modifier.isPrivate(desField.getModifiers())) {
                        String fieldName = srcField.getAnnotation(FieldOf.class).value();
                        Method getter = getGetMethod(src, fieldName);
                        Method setter = getSetMethod(des, desField);
                        if (getter != null && setter != null) {
                            Object o = getter.invoke(src);
                            setter.invoke(des, o);
                        }
                    } else srcField.set(des, srcField.get(src));
                }
            }
        }
    }

    public static boolean checkAnnotation(Field studentField, Field employeeField) {
        FieldOf sFieldOf = studentField.getAnnotation(FieldOf.class);
        FieldOf eFieldOf = employeeField.getAnnotation(FieldOf.class);
        if (sFieldOf == null || eFieldOf == null) {
            return false;
        }
        return sFieldOf.value().equals(eFieldOf.value());
    }

    public static Method getGetMethod(Object src, String fieldName) throws NoSuchMethodException {
        String methodName = "get" + fieldName;
        Method method = src.getClass().getMethod(methodName);
        return method;
    }

    public static Method getSetMethod(Object des, Field field) throws NoSuchMethodException {
        String methodName = "set" + cap(field.getName());
        Method method = des.getClass().getMethod(methodName, field.getType());
        return method;
    }

    public static String cap(String str) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i == 0) {
                char ch = (char) (str.charAt(i) - 32);
                res.append(ch);
            } else res.append(str.charAt(i));
        }
        return res.toString();
    }
}
