package objtoobjconversion;

import study.annotations.FieldOf;

import java.lang.reflect.*;

public class ObjConversion {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> studentClass = Student.class;
        Class<?> employeeClass = Employee.class;
        Class<?> addressClass = Address.class;
        Constructor<?> addressConst = addressClass.getDeclaredConstructor(int.class, String.class, String.class, String.class);
        Object address = addressConst.newInstance(321, "Bharathiyar Nagar", "Tirunelveli", "Tamil Nadu");
        Constructor<?> studentConst = studentClass.getDeclaredConstructor(String.class, int.class, String.class, Address.class);
        Object student = studentConst.newInstance("Mervin", 21, "7904786800", address);
        Constructor<?> employeeConst = employeeClass.getDeclaredConstructor();
        Object employee = employeeConst.newInstance();
        Employee emp = new Employee("Meganathan", 23, "6478970203", new Address(05, "Gandhi Nagar", "Krishnagiri", "Tamil Nadu"));
        Student std = new Student();
        convert(student, employee);
        convert(emp, std);
    }

    public static void convert(Object obj1, Object obj2) {
        Class<?> obj1Class = obj1.getClass();
        Class<?> obj2Class = obj2.getClass();

        Field[] obj1Fields = obj1Class.getDeclaredFields();
        Field[] obj2Fields = obj2Class.getDeclaredFields();

        for (Field obj1Field : obj1Fields) {

            for (Field obj2Field : obj2Fields) {

                if (checkAnnotation(obj1Field, obj2Field)) {
                    if (Modifier.isPrivate(obj1Field.getModifiers()) || Modifier.isPrivate(obj2Field.getModifiers())) {
                        String fieldName = obj1Field.getAnnotation(FieldOf.class).value();
                        Method getter = getGetMethod(obj1, fieldName);
                        Method setter = getSetMethod(obj2, obj2Field);
                        if (getter != null && setter != null) {
                            try {
                                Object o = getter.invoke(obj1);
                                setter.invoke(obj2, o);
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                System.err.println("Method can't be accessed here " + e.getCause());
                            }
                        }
                    } else {
                        try {
                            obj2Field.set(obj2, obj1Field.get(obj1));
                        } catch (IllegalAccessException e) {
                            System.err.println("Field can't be accessed here " + e.getCause());
                        }
                    }
                }
            }
        }
        System.out.println(obj1);
        System.out.println(obj2);
    }

    public static boolean checkAnnotation(Field studentField, Field employeeField) {
        FieldOf sFieldOf = studentField.getAnnotation(FieldOf.class);
        FieldOf eFieldOf = employeeField.getAnnotation(FieldOf.class);
        if (sFieldOf == null || eFieldOf == null) {
            return false;
        }
        return sFieldOf.value().equals(eFieldOf.value());
    }

    public static Method getGetMethod(Object obj, String field) {
        String methodName = "get" + field;
        try {
            Method method = obj.getClass().getDeclaredMethod(methodName);
            return method;
        } catch (NoSuchMethodException e) {
            System.err.println("No Method with the name " + methodName + "()");
        }
        return null;
    }

    public static Method getSetMethod(Object obj, Field field) {
        String methodName = "set" + cap(field.getName());
        try {
            Method method = obj.getClass().getDeclaredMethod(methodName, field.getType());
            return method;
        } catch (NoSuchMethodException e) {
            System.err.println("No Method with the name " + methodName + "()");
        }
        return null;
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
