package domain;

public class Student implements Comparable<Student> {

    private long regNumber;
    private String firstName, lastName, city;

    public Student(long regNumber, String firstName, String lastName, String city) {
        this.regNumber = regNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
    }

    public long getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(long regNumber) {
        this.regNumber = regNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "regNumber=" + regNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return Long.compare(this.regNumber, o.regNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return regNumber == student.regNumber;

    }

    @Override
    public int hashCode() {
        return (int) (regNumber ^ (regNumber >>> 32));
    }
}
