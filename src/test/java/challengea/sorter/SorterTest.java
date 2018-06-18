package challengea.sorter;

import challengea.sorter.classes.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SorterTest {

    @Test
    public void sortClasses() {

        Class[] classes = {D.class, A.class, C.class, B.class};

        Class[] classesAfterSorting = {A.class, C.class, D.class, B.class};

        Sorter.sortClasses(classes);

        assertTrue(Arrays.equals(classes, classesAfterSorting));
    }


    @Test
    public void sortInterfaces() {

        Class[] interfaces = {IC.class, IB.class, IA.class};

        Class[] interfacesAfterSorting = {IB.class, IC.class, IA.class};

        Sorter.sortClasses(interfaces);

        assertTrue(Arrays.equals(interfaces, interfacesAfterSorting));
    }
}
