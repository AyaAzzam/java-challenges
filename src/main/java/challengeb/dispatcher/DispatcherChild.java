package challengeb.dispatcher;

import challengea.sorter.classes.B;

public class DispatcherChild extends Dispatcher {


    public DispatcherChild() {
        super("test");
    }

    public Object test(Object par) {
        System.out.println("Object");
        return par;
    }

    public Object test(String par) {
        System.out.println("String");
        return par;
    }

    public Object test(Integer par) {
        System.out.println("integer");
        return par;
    }

    public Object test(B par) {
        System.out.println("Object B");
        return par;
    }


}
