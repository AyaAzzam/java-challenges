package challengeb.dispatcher;

import challengea.sorter.Sorter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Dispatcher {

    private String methodName;

    public Dispatcher(String methodName) {

        this.methodName = methodName;

    }

    public Object dispatch(Object param) {

        try {

            Method methodByNameAndParam = getMethodByNameAndParam(param);

            if (methodByNameAndParam != null) {

                return methodByNameAndParam.invoke(this, param);

            } else {

                System.out.println("no match can be found");
            }

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {

            System.out.println("error: " + e.getMessage());

        }

        return null;

    }

    /**
     * Try to get the method with the exact same param type
     *
     * @param param
     * @return method
     */
    public Method getMethodByNameAndParam(Object param) throws NoSuchMethodException {

        Method method = null;

        try {

            method = this.getClass().getDeclaredMethod(methodName, param.getClass());

        } catch (NoSuchMethodException e) {

            System.out.println("The method with the exact same param type not found");

        } finally {

            if (method == null) {

                List<Class> allMethodsWithName = getAllQualifiedMethodParamTypes(param);

                Class[] classes = new Class[allMethodsWithName.size()];

                classes = allMethodsWithName.toArray(classes);

                Sorter.sortClasses(classes);

                if (classes.length > 0) {

                    method = this.getClass().getDeclaredMethod(methodName, classes[0]);
                }

            }

        }

        return method;
    }

    /**
     * Get all Qualified Method Param Types
     *
     * @param param
     * @return method
     */

    public List<Class> getAllQualifiedMethodParamTypes(Object param) {

        Method[] allMethods = this.getClass().getDeclaredMethods();

        List<Class> allQualifiedMethodParamTypes = new ArrayList<>();

        for (Method allMethod : allMethods) {

            if (allMethod.getName().equals(methodName)
                    && allMethod.getParameterTypes()[0].isAssignableFrom(param.getClass())) {

                allQualifiedMethodParamTypes.add(allMethod.getParameterTypes()[0]);
            }
        }

        return allQualifiedMethodParamTypes;
    }


}
