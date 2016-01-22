import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by YB on 22.01.2016.
 */
public class Demo {

    public static void main(String[] args) {
        ArrayList list = new ArrayList();

        ClassInfo classInfo = new ClassInfo();

        System.out.println("=====Print all class hierarchy=======");
        classInfo.printClassInfo(list.getClass());
        System.out.println("=====Print all class hierarchy methods=======");
        classInfo.printClassMethods(list.getClass());
        System.out.println("=====Print all class hierarchy fields v.1=======");
        classInfo.printClassFields(list.getClass());
        System.out.println("=====Print all class hierarchy fields v.2=======");
        classInfo.printClassFields2(list.getClass());

    }

}
