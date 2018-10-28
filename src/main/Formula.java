package main;

/**
 * Add non-abstract method implementation to an interface using the default keyword.
 * This is known as an extension method.
 */

public interface Formula {

    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
