package u1.home.task1;

import java.lang.reflect.*;


public class ReflactoinMethod {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Class<?> cls = Klass1.class;
        Method[] methods = cls.getDeclaredMethods();
        for (Method met : methods) {
            if (met.isAnnotationPresent(Annot.class)) {
                Annot annot = met.getAnnotation(Annot.class);
                System.out.println(met.invoke("cls", annot.a(), annot.b()));

            }
        }
    }
}

