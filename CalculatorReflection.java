import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionCalculator {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("testCalc.txt"))) {
            String methodName = reader.readLine();
            String a = reader.readLine();
            String b = reader.readLine();

            Calculator calculator = new Calculator();
            Class<? extends Calculator> calculatorClass = calculator.getClass();
            Method method = null;
            Method[] methods = calculatorClass.getDeclaredMethods();
            for (Method myMethod : methods) {
                if (myMethod.getName().equals(methodName)) {
                    method = myMethod;
                }
            }
            assert method != null;
            method.invoke(calculator, Integer.parseInt(a), Integer.parseInt(b));
        } catch (IOException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }
}

class Calculator {
    void sum(int a, int b) {
        int result = a + b;
        System.out.println("sum of " + a + " and " + b + " = " + result);
    }

    void subtraction(int a, int b) {
        int result = a - b;
        System.out.println("raznitsa of " + a + " and " + b + " = " + result);
    }

    void multiplication(int a, int b) {
        int result = a * b;
        System.out.println("proizvedenie of " + a + " and " + b + " = " + result);
    }

    void division(int a, int b) {
        int result = a / b;
        System.out.println("division of " + a + " and " + b + " = " + result);
    }

}
