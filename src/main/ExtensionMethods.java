package main;

public class ExtensionMethods {

    public static void main(String[] args) {

        // implemented as an anonymous object
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        System.out.println(formula.calculate(100));
        System.out.println(formula.sqrt(16));
    }
}
