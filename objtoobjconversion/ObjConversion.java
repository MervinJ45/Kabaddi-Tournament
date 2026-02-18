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
        convert(student, employee);
    }

    public static void convert(Object student, Object employee) throws IllegalAccessException, InvocationTargetException {
        Class<?> studentClass = student.getClass();
        Class<?> employeeClass = employee.getClass();
        //System.out.println(studentClass+" "+employeeClass);

        Field[] studentFields = studentClass.getDeclaredFields();
        Field[] employeeFields = employeeClass.getDeclaredFields();

        for (Field studentField : studentFields) {
            studentField.setAccessible(true);

            for (Field employeeField : employeeFields) {
                employeeField.setAccessible(true);

                if (checkAnnotation(studentField, employeeField)) {
                    String fieldName = studentField.getAnnotation(FieldOf.class).value();
                    Method getter = getGetMethod(student,fieldName);
                    Method setter = getSetMethod(employee,fieldName);
                    setter.invoke(employee,getter.invoke(student));
                    System.out.println(fieldName);
                    employeeField.set(employee, studentField.get(student));
                }
            }
        }

        System.out.println(student);
        System.out.println(employee);
    }

    public static boolean checkAnnotation(Field studentField, Field employeeField) {
        FieldOf sFieldOf = studentField.getAnnotation(FieldOf.class);
        FieldOf eFieldOf = employeeField.getAnnotation(FieldOf.class);
        if (sFieldOf.value().equals(eFieldOf.value())) {
            return true;
        }
        return false;
    }

    public static Method getGetMethod(Object obj, String field){
        return null;
    }

    public static Method getSetMethod(Object obj, String field){
        return null;
    }
}
