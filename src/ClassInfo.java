import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by YB on 22.01.2016.
 */
public class ClassInfo {

    private static List<Class> classes = new ArrayList<Class>();

    ClassInfo () {};

    public static void printClassInfo (Class klass) {
        List <Class> cls = getAllClasses(klass);
        for (Class clss : cls)
        {
            System.out.println(clss.getSimpleName());
        }
    }

    public static void printClassMethods (Class klass) {
        List <Method> mthd = getAllMethod(klass);
        for (Method mthds : mthd)
        {
            mthds.setAccessible(true);
            System.out.println(mthds.getName().toString());
        }
    }

    public static void printClassFields (Class klass) {
        List<Field> fs = getAllFields(klass);
        for (Field field : fs)
        {
            field.setAccessible(true);
            System.out.println(field.getName().toString());
        }
    }

    public static void printClassFields2 (Class klass) {
        Field[] fields = getAllFields2(klass);
        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }

    public static List<Field> getAllFields(Class klass) {
        List<Field> fields = new ArrayList<Field>();
        for (Class clss : getAllClasses(klass)) {
            fields.addAll(Arrays.asList(clss.getDeclaredFields()));
        }
        return fields;
    }

    public static Field[] getAllFields2(Class klass) {
        List<Field> fields = new ArrayList<Field>();
        fields.addAll(Arrays.asList(klass.getDeclaredFields()));
        if (klass.getSuperclass() != null) {
            fields.addAll(Arrays.asList(getAllFields2(klass.getSuperclass())));
        }
        return fields.toArray(new Field[] {});
    }

    public static List<Method> getAllMethod(Class klass) {
        List<Method> methods = new ArrayList<Method>();
        for (Class clss : getAllClasses(klass)) {
            methods.addAll(Arrays.asList(clss.getDeclaredMethods()));
        }
        return methods;
    }

    public static List<Class> getAllClasses(Class klass) {
        Class clss = klass;
        classes.add(clss);
        if (clss.getSuperclass() != null) {
            getAllClasses(clss.getSuperclass());
        }
        return classes;
    }
}
