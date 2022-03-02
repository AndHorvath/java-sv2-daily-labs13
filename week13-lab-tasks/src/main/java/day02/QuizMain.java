package day02;

import java.nio.file.Path;

public class QuizMain {

    public static void main(String[] args) {
        Path path = Path.of("src/main/resources/result.txt");
        Quiz quiz = new Quiz();

        quiz.readFile(path);

        System.out.println(quiz.getSolutions());
        System.out.println(quiz.getPlayersAndAnswers());

        System.out.println(quiz.checkPlayersAnswer("AB123", 1));
        System.out.println(quiz.checkPlayersAnswer("AB123", 2));
        System.out.println(quiz.getBestPlayer());
    }
}