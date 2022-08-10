package mx.meli.mutant.util;

public class MutantUtil {
    public static String[][] arrayToMultidimencionalArray(String[] array) {
        String[][] response = new String[array.length][];
        for (int i = 0; i < array.length; i++) {
            response[i] = new String[]{array[i]};
        }
        return response;
    }
}
