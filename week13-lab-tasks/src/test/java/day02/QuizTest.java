package day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuizTest {

    Quiz quiz;
    Path path;
    Throwable exception;

    @BeforeEach
    void setUp() {
        quiz = new Quiz();
        path = Path.of("src/test/resources/result.txt");
    }

    @Test
    void getSolutionsTest() {
        assertEquals(new ArrayList<>(), quiz.getSolutions());
    }

    @Test
    void getPlayersAndAnswersTest() {
        assertEquals(new HashMap<>(), quiz.getPlayersAndAnswers());
    }

    @Test
    void readFileTest() {
        quiz.readFile(path);
        assertEquals(4, quiz.getPlayersAndAnswers().size());
        assertEquals(List.of('A', 'C', 'C', 'B', 'X'), quiz.getPlayersAndAnswers().get("AB123"));
        assertTrue(quiz.getPlayersAndAnswers().containsKey("AH2"));

        exception = assertThrows(
            IllegalStateException.class,
            () -> quiz.readFile(Path.of("src/test/resources/result_.txt"))
        );
        assertEquals("Cannot read file.", exception.getMessage());
    }

    @Test
    void checkPlayersAnswerTest() {
        quiz.readFile(path);
        assertTrue(quiz.checkPlayersAnswer("AB123", 1));
        assertFalse(quiz.checkPlayersAnswer("AB123", 2));
    }

    @Test
    void getBestPlayerTest() {
        quiz.readFile(path);
        assertEquals("GH1234", quiz.getBestPlayer());
    }
}