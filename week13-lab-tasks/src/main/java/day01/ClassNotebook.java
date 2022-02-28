package day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ClassNotebook {

    // --- attributes ---------------------------------------------------------

    private Map<Student, List<Integer>> studentsAndMarks;

    // --- constructors -------------------------------------------------------

    public ClassNotebook() {
        this.studentsAndMarks = new TreeMap<>();
    }

    // --- getters and setters ------------------------------------------------

    public Map<Student, List<Integer>> getStudentsAndMarks() { return studentsAndMarks; }

    // --- public methods -----------------------------------------------------

    public void addStudent(Student student) {
        validateParameter(student);
        studentsAndMarks.put(student, new ArrayList<>());
    }

    public void addMark(int id, int mark) {
        for (Student student : studentsAndMarks.keySet()) {
            if (student.getId() == id) {
                studentsAndMarks.get(student).add(mark);
                return;
            }
        }
        handleInvalidParameter();
    }

    // --- private methods ----------------------------------------------------

    private void validateParameter(Student student) {
        if (studentsAndMarks.containsKey(student)) {
            throw new IllegalArgumentException("Specified student has already been added.");
        }
    }

    private void handleInvalidParameter() {
        throw new IllegalArgumentException("No student in notebook with specified id.");
    }
}