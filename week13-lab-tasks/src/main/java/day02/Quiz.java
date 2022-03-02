package day02;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class Quiz {

    // --- attributes ---------------------------------------------------------

    private static final String SEPARATOR = " ";

    private List<Character> solutions;
    private Map<String, List<Character>> playersAndAnswers;

    // --- constructors -------------------------------------------------------

    public Quiz() {
        solutions = new ArrayList<>();
        playersAndAnswers = new HashMap<>();
    }

    // --- getters and setters ------------------------------------------------

    public List<Character> getSolutions() { return solutions; }
    public Map<String, List<Character>> getPlayersAndAnswers() { return playersAndAnswers; }

    // --- public methods -----------------------------------------------------

    public void readFile(Path path) {
        try (Scanner scanner = new Scanner(path)) {
            for (Character character : scanner.nextLine().toCharArray()) {
                solutions.add(character);
            }
            while (scanner.hasNextLine()) {
                String[] playerAndAnswers = scanner.nextLine().split(SEPARATOR);
                if (!playersAndAnswers.containsKey(playerAndAnswers[0])) {
                    playersAndAnswers.put(playerAndAnswers[0], new ArrayList<>());
                }
                playersAndAnswers.get(playerAndAnswers[0]).add(playerAndAnswers[1].charAt(0));
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("Cannot read file.", ioException);
        }
    }

    public boolean checkPlayersAnswer(String code, int answerNumber) {
        return playersAndAnswers.get(code).get(answerNumber - 1) == solutions.get(answerNumber - 1);
    }

    public String getBestPlayer() {
        Map<String, Integer> playersAndPoints = createPlayersAndPoints();
        return findBestPlayer(playersAndPoints);
    }

    // --- private methods ----------------------------------------------------

    private Map<String, Integer> createPlayersAndPoints() {
        Map<String, Integer> playersAndPoints = new HashMap<>();
        for (String player : playersAndAnswers.keySet()) {
            if (!playersAndPoints.containsKey(player)) {
                playersAndPoints.put(player, 0);
            }
            updatePlayersAndPoints(player, playersAndPoints);
        }
        return playersAndPoints;
    }

    private String findBestPlayer(Map<String, Integer> playersAndPoints) {
        String bestPlayer = null;
        int bestResult = Integer.MIN_VALUE;
        for (String player : playersAndPoints.keySet()) {
            if (bestPlayer == null || playersAndPoints.get(player) > bestResult) {
                bestPlayer = player;
                bestResult = playersAndPoints.get(player);
            }
        }
        return bestPlayer;
    }

    private void updatePlayersAndPoints(String player, Map<String, Integer> playersAndPoints) {
        for (int i = 0; i < solutions.size(); i++) {
            if (playersAndAnswers.get(player).get(i) != 'X') {
                if (checkPlayersAnswer(player, i + 1)) {
                    playersAndPoints.put(player, playersAndPoints.get(player) + i + 1);
                } else {
                    playersAndPoints.put(player, playersAndPoints.get(player) - 2);
                }
            }
        }
    }
}