package mx.meli.mutant.service;

import lombok.extern.slf4j.Slf4j;
import mx.meli.mutant.util.MutantUtil;

@Slf4j
public class MutantService {
    /**
     * Dado un array, valida si es un mutante
     */
    public boolean isMutant(String[] adn) {
        boolean isMutant = false;
        //buscar mutante en lineas de forma horizontal
        for (String line : adn) {
            if (MutantUtil.adnLineIsMutant(line)) {
                return true;
            }
        }
        //buscar mutante en lineas de forma vertical
        for (int column = 0; column < adn[0].length(); column++) {
            if (MutantUtil.adnLineIsMutant(MutantUtil.getLineVertical(adn, column))) {
                return true;
            }
        }
        //buscar mutante en lineas de forma obliqua

        return isMutant;
    }


}
