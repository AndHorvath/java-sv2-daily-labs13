package day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    Student student;
    Student other;

    @BeforeEach
    void setUp() {
        student = new Student(1, "Student A");
    }

    @Test
    void getIdTest() {
        assertEquals(1, student.getId());
    }

    @Test
    void getNameTest() {
        assertEquals("Student A", student.getName());
    }

    @Test
    void compareToTest() {
        other = new Student(2, "Student B");
        assertTrue(student.compareTo(other) < 0);
    }
}