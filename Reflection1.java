import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Reflection1 {
    public static void main(String[] args) {
        Class<Dragon2> dragonClass = Dragon2.class;
        System.out.println("Information about fields: ");
        Field[] dragonFields = dragonClass.getDeclaredFields();
        for (Field field : dragonFields) {
            System.out.println("Field name " + field.getName() + ", field Type " + field.getType());
        }
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("Information about methods: ");
        Method[] dragonMethods = dragonClass.getDeclaredMethods();
        for (Method method : dragonMethods) {
            if (Modifier.isPublic(method.getModifiers()))
                System.out.println("Method name " + method.getName() +
                        ", return type " + method.getReturnType() +
                        ", parameter types " + Arrays.toString(method.getParameterTypes()));

        }
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("Information about constructors: ");
        Constructor[] dragonConstructors = dragonClass.getDeclaredConstructors();
        for (Constructor constructor:dragonConstructors){
            System.out.println("Parameter count "+constructor.getParameterCount()
            +", parameter types "+ Arrays.toString(constructor.getParameterTypes()));
        }

    }
}
