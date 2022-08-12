package mx.meli.mutant.validation;

import mx.meli.mutant.exception.MutanManagerException;

public class MutantManagerValidation {

    public static void validADN(String[] adn) throws MutanManagerException {
        int size = adn.length;
        for (String line : adn) {
            if (line.length() != size) {
                throw new MutanManagerException("Input ADN invalid");
            }
        }
    }
}
