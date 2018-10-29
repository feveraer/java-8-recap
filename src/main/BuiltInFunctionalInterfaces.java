package main;

import domain.Student;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BuiltInFunctionalInterfaces {

    public static void main(String[] args) {

        // Predicates are functions taking one argument and returning a boolean

        Predicate<String> predicate = (s) -> s.length() > 0;

        System.out.println(predicate.test("foo"));          // true
        System.out.println(predicate.negate().test("bar")); // false

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();

        // Functions accept one argument and produce a result.
        // Default methods can be used to chain multiple functions together
        // (compose, andThen)

        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        System.out.println(toInteger.apply("123").getClass().getSimpleName());
        System.out.println(backToString.apply("123").getClass().getSimpleName());

        // Suppliers produce a result of a given generic type.
        // They don't accept arguments.

        Supplier<Student> studentSupplier = Student::new;
        System.out.println(studentSupplier.get());

        // Consumers represent operations to be performed on a single input argument

        Consumer<Student> greeter = (s) -> System.out.println("Hello, " + s.getFirstName());
        greeter.accept(new Student(123456789, "John", "Wick", "New York City"));

        // Optionals are not functional interface, but it's used to prevent NullPointerExceptions.
        // This is an important concept for Streams.
        // An Optional is a simple container for a value which may be null or not.

        Optional<String> optional = Optional.of("bam");
        if (optional.isPresent()) {
            System.out.println(optional.get());
        }
        System.out.println(optional.orElse("fallback"));

        optional.ifPresent((s) -> System.out.println(s.charAt(0)));
    }
}
