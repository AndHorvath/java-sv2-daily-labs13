package day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import static org.junit.jupiter.api.Assertions.*;

class ClassNotebookTest {

    ClassNotebook classNotebook;
    Student studentA;
    Student studentB;
    Student studentC;

    Throwable exception;

    @BeforeEach
    void setUp() {
        classNotebook = new ClassNotebook();

        studentA = new Student(14, "Student A");
        studentB = new Student(21, "Student B");
        studentC = new Student(28, "Student C");
    }

    @Test
    void getStudentsAndMarksTest() {
        assertEquals(new TreeMap<>(), classNotebook.getStudentsAndMarks());
    }

    @Test
    void addStudentTest() {
        classNotebook.addStudent(studentA);
        assertEquals(1, classNotebook.getStudentsAndMarks().size());
        assertTrue(classNotebook.getStudentsAndMarks().containsKey(studentA));
        assertEquals(new ArrayList<>(), classNotebook.getStudentsAndMarks().get(studentA));

        classNotebook.addStudent(studentC);
        classNotebook.addStudent(studentB);
        assertEquals(studentB, classNotebook.getStudentsAndMarks().keySet().toArray()[1]);

        exception = assertThrows(IllegalArgumentException.class, () -> classNotebook.addStudent(studentA));
        assertEquals("Specified student has already been added.", exception.getMessage());
    }

    @Test
    void addMarkTest() {
        classNotebook.addStudent(studentA);
        classNotebook.addMark(14, 5);
        assertEquals(5, classNotebook.getStudentsAndMarks().get(studentA).get(0));

        exception = assertThrows(IllegalArgumentException.class, () -> classNotebook.addMark(21, 5));
        assertEquals("No student in notebook with specified id.", exception.getMessage());
    }
}