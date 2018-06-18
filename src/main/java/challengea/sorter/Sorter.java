package challengea.sorter;

public class Sorter {

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static void sortClasses(Class[] classes) {

        for (int i = classes.length - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {

                if (classes[j + 1].isAssignableFrom(classes[j])) {

                    swapValues(classes, j, j + 1);
                }
            }
        }
    }


    private static void swapValues(Class[] theArray, int indexOne, int indexTwo) {
        Class temp = theArray[indexOne];
        theArray[indexOne] = theArray[indexTwo];
        theArray[indexTwo] = temp;

    }

}
