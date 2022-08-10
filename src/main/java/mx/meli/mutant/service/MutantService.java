package mx.meli.mutant.service;

import lombok.extern.slf4j.Slf4j;

import java.util.regex.Pattern;

@Slf4j
public class MutantService {
    /**
     * Dado un array, valida si es un mutante
     */
    public boolean isMutant(String[] adn) {
        boolean isMutant = false;
        //buscar mutante en lineas de forma horizontal
        for (String line : adn) {
            if (containsANDMutant(line)) {
                return true;
            }
        }
        //buscar mutante en lineas de forma vertical
        for (int column = 0; column < adn[0].length(); column++) {
            if (containsANDMutant(getLineVertical(adn, column))) {
                return true;
            }
        }
        return isMutant;
    }

    private String getLineVertical(String[] adn, int column) {
        StringBuilder line = new StringBuilder();
        for (int row = 0; row < adn.length; row++) {
            line.append(adn[row].charAt(column));
        }
        return line.toString();
    }

    private static boolean containsANDMutant(String line) {
        log.debug("line: {}", line);
        Pattern pat = Pattern.compile(".*AAAA.*");
        if (pat.matcher(line).matches()) {
            return true;
        }
        pat = Pattern.compile(".*TTTT.*");
        if (pat.matcher(line).matches()) {
            return true;
        }
        pat = Pattern.compile(".*CCCC.*");
        if (pat.matcher(line).matches()) {
            return true;
        }
        pat = Pattern.compile(".*GGGG.*");
        if (pat.matcher(line).matches()) {
            return true;
        }
        return false;
    }
}
