package mx.meli.mutant.util;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Slf4j
public class MutantUtil {

    public static List<Pattern> patternsMutant;
    public static final int MIN_SIZE_LINE_ADN = 4;

    static {
        patternsMutant = new ArrayList<>();
        patternsMutant.add(MutantPattern.patternAAAA);
        patternsMutant.add(MutantPattern.patternTTTT);
        patternsMutant.add(MutantPattern.patternCCCC);
        patternsMutant.add(MutantPattern.patternGGGG);
    }

    /**
     * Valida si una cadena corresponde a un ADN mutante
     *
     * @param line linea a evaluar
     */
    public static boolean adnLineIsMutant(String line) {
        return patternsMutant.stream().anyMatch(pattern -> pattern.matcher(line).matches());
    }

    /**
     * Obtiene la cadena vertical de un arraglo, dada una columna enviada
     *
     * @param array  el array de cadenas
     * @param column columna de la cadena
     */
    public static String getLineVertical(String[] array, int column) {
        StringBuilder line = new StringBuilder();
        try {
            for (int row = 0; row < array.length; row++) {
                line.append(array[row].charAt(column));
            }
        } catch (IndexOutOfBoundsException e) {
            log.warn("column not exist");
        }
        return line.toString();
    }

    /**
     * Obtiene un arraglo de cadenas oblicuas dado un arragle de cadenas
     * obtiene tanto la diagonal de enmedio, como las de arriba y abajo
     * que tengan al menos el minumo de letras para validar una secuencia mutante
     *
     * @param array array de cadenas
     */
    public static List<String> getArrayLinesObliqua(String[] array) {
        List<String> arrayLines = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            String lineUp = getLineObliquaUpArray(array, MIN_SIZE_LINE_ADN, i);
            if (!lineUp.isEmpty()) {
                arrayLines.add(lineUp);
            }
            String lineDown = getLineObliquaDownArray(array, MIN_SIZE_LINE_ADN, i + 1);
            if (!lineDown.isEmpty()) {
                arrayLines.add(lineDown);
            }
        }
        return arrayLines;
    }


    private static String getLineObliquaUpArray(String[] array, int minSize, int init) {
        StringBuilder lineBuilder = new StringBuilder();
        if ((array.length - init) >= minSize) {
            for (String line : array) {
                if (init < array.length) {
                    lineBuilder.append(line.charAt(init++));
                }
            }
        }
        return lineBuilder.toString();
    }

    private static String getLineObliquaDownArray(String[] array, int minSize, int init) {
        StringBuilder lineBuilder = new StringBuilder();
        if ((minSize + init) <= array.length) {
            int firstInit = init;
            if (init < array.length) {
                for (int i = 0; i < (array.length - firstInit); i++) {
                    char charAt = array[init].charAt(i);
                    lineBuilder.append(charAt);
                    init++;
                }
            }
        }
        return lineBuilder.toString();
    }
}
