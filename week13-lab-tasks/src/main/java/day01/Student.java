package day01;

public class Student implements Comparable<Student> {

    // --- attributes ---------------------------------------------------------

    private int id;
    private String name;

    // --- constructors -------------------------------------------------------

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // --- getters and setters ------------------------------------------------

    public int getId() { return id; }
    public String getName() { return name; }

    // --- public methods -----------------------------------------------------

    @Override
    public int compareTo(Student other) {
        return Integer.compare(id, other.id);
    }
}