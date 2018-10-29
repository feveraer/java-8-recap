package main;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortingHat {

    /**
     *  Calling the .sorted() method on a stream of strings will compare
     *  two strings lexicographically and is based on the unicode value
     *  of each character in the string. "aAbaBb" => "ABaabb".
     *  However want our sort to do: "aAbaBb" => "AaaBbb".
     *  Sorting on natural order first and then sorting the result ignoring
     *  the case gives us the desired outcome.
     */

    public String naturalOrderButBetter(final String text) {

        return Stream.of(text.split(""))
                .sorted()
                .sorted(String::compareToIgnoreCase)
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        SortingHat sortingHat = new SortingHat();
        System.out.println(sortingHat.naturalOrderButBetter("aAbaBb"));
    }
}
