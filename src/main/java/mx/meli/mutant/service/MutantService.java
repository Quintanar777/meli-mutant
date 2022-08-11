package mx.meli.mutant.service;

import lombok.extern.slf4j.Slf4j;
import mx.meli.mutant.util.MutantUtil;

import java.util.List;

@Slf4j
public class MutantService {

    private static final int MIN_SEC_MUTANT = 2;

    /**
     * Dado un array, valida si es un mutante
     */
    public boolean isMutant(String[] adn) {
        boolean isMutant = false;
        short countSec = 0;

        short countSecHorizontal = getCountSecHorizontal(adn);
        countSec += countSecHorizontal;
        if (countSec >= MIN_SEC_MUTANT) {
            return true;
        }

        short countSecVertical = getCountSecVertical(adn);
        countSec += countSecVertical;
        if (countSec >= MIN_SEC_MUTANT) {
            return true;
        }
        short countSecObliqua = getCountSecObliqua(adn);
        countSec += countSecObliqua;
        if (countSec >= MIN_SEC_MUTANT) {
            return true;
        }

        return isMutant;
    }

    /**
     * Cuenta el numero de secuencias de ADN mutante de las lineas horizontalmente
     */
    private short getCountSecHorizontal(String[] adn) {
        short count = 0;
        for (String line : adn) {
            if (MutantUtil.adnLineIsMutant(line)) {
                count++;
            }
        }
        return count;
    }

    private short getCountSecVertical(String[] adn) {
        short count = 0;
        for (int column = 0; column < adn[0].length(); column++) {
            if (MutantUtil.adnLineIsMutant(MutantUtil.getLineVertical(adn, column))) {
                count++;
            }
        }
        return count;
    }

    private short getCountSecObliqua(String[] adn) {
        short count = 0;
        List<String> arrayLinesObliqua = MutantUtil.getArrayLinesObliqua(adn);
        for (String lineObl : arrayLinesObliqua) {
            if (MutantUtil.adnLineIsMutant(lineObl)) {
                count++;
            }
        }
        return count;
    }
}
