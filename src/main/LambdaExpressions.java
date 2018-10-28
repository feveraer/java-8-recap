package main;

import domain.Student;

import java.util.*;

public class LambdaExpressions {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student(2018978123, "Jack", "Daniels", "New York City"),
                new Student(2018978124, "Jenny", "Dorsey", "Boston"),
                new Student(2018978121, "Josh", "Daniels", "New York City")
                );

        // java 7
        /*Collections.sort(students, new Comparator<Student>() {
            // sort first on name, then on reg number
            @Override
            public int compare(Student s1, Student s2) {
                int result = s1.getLastName().compareTo(s2.getLastName());
                if (result == 0) {
                    result = s1.compareTo(s2);
                }
                return result;
            }
        });*/

        // java 8 lambda expressions
        // sort on name first, then reg number
        Collections.sort(students, (s1, s2) -> {
            int result = s1.getLastName().compareTo(s2.getLastName());
            if (result == 0) {
                result = s1.compareTo(s2);
            }
            return result;
        });

        System.out.println(students);
    }
}
