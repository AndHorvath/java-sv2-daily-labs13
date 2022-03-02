package day04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import static org.junit.jupiter.api.Assertions.*;

class StringStatisticsTest {

    StringStatistics stringStatistics;
    String text;

    @BeforeEach
    void setUp() {
        stringStatistics = new StringStatistics();
        text = "Create string statistics!";
    }

    @Test
    void createStatisticsTest() {
        Map<Character, Integer> statistics = stringStatistics.createStatistics(text);

        assertEquals(3, statistics.size());
        assertEquals(2, statistics.get('a'));
        assertEquals(2, statistics.get('e'));
        assertEquals(3, statistics.get('i'));

        assertEquals(new TreeSet<>(List.of('a', 'e', 'i')), statistics.keySet());
    }
}