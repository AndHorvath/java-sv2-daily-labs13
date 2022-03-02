package day04;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StringStatistics {

    public Map<Character, Integer> createStatistics(String text) {
        Map<Character, Integer> statistics = new TreeMap<>();
        for (char character : text.toLowerCase().toCharArray()) {
            updateStatistics(statistics, character);
        }
        return statistics;
    }

    // --- private methods ----------------------------------------------------

    private void updateStatistics(Map<Character, Integer> statistics, char character) {
        List<Character> vowels = getVowels();
        if (vowels.contains(character)) {
            if (statistics.containsKey(character)) {
                statistics.put(character, statistics.get(character) + 1);
            } else {
                statistics.put(character, 1);
            }
        }
    }

    private List<Character> getVowels() {
        return List.of('a', 'e', 'i', 'o', 'u');
    }
}