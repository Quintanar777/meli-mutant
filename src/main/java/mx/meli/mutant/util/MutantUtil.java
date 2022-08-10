package mx.meli.mutant.util;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Slf4j
public class MutantUtil {

    public static List<Pattern> patternsMutant;

    static {
        patternsMutant = new ArrayList<>();
        patternsMutant.add(MutantPattern.patternAAAA);
        patternsMutant.add(MutantPattern.patternTTTT);
        patternsMutant.add(MutantPattern.patternCCCC);
        patternsMutant.add(MutantPattern.patternGGGG);
    }

    public static boolean adnLineIsMutant(String line) {
        return patternsMutant.stream().anyMatch(pattern -> pattern.matcher(line).matches());
    }

    public static String getLineVertical(String[] adn, int column) {
        StringBuilder line = new StringBuilder();
        try {
            for (int row = 0; row < adn.length; row++) {
                line.append(adn[row].charAt(column));
            }
        } catch (IndexOutOfBoundsException e) {
            log.warn("column not exist");
        }
        return line.toString();
    }

    public static String[] getArrayLinesObliqua(String[] array) {

        return null;
    }
}
